package br.com.alura.med.voll.api.controller;

import br.com.alura.med.voll.api.domain.paciente.DadosListaPaciente;
import br.com.alura.med.voll.api.domain.paciente.Paciente;
import br.com.alura.med.voll.api.domain.paciente.PacienteRepository;
import br.com.alura.med.voll.api.domain.paciente.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosPaciente dados, UriComponentsBuilder builder){
       var paciente = new Paciente(dados);
       repository.save(paciente);
       var uri = builder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
       return ResponseEntity.created(uri).body(new DadosDetalhePaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListaPaciente>> listar(@PageableDefault(size = 5,sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListaPaciente::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var pacienteAtual = repository.getReferenceById(id);
        pacienteAtual.excluir();
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaPaciente dadosPaciente) {
        var paciente = repository.getReferenceById(dadosPaciente.id());
        paciente.atualizarInformacoes(dadosPaciente);
        return ResponseEntity.ok(new DadosDetalhePaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var pacienteAtual = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhePaciente(pacienteAtual));
    }
}

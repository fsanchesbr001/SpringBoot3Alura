package br.com.alura.med.voll.api.controller;

import br.com.alura.med.voll.api.domain.medico.DadosListaMedico;
import br.com.alura.med.voll.api.domain.medico.Medico;
import br.com.alura.med.voll.api.domain.medico.MedicoRepository;
import br.com.alura.med.voll.api.domain.medico.*;
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
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosMedico dados, UriComponentsBuilder uriBuilder){

        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalheMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListaMedico>> listar(@PageableDefault(size = 5,sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListaMedico::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaMedico dadosMedico){
        var medicoAtual = repository.getReferenceById(dadosMedico.id());
        medicoAtual.atualizarInformacoes(dadosMedico);
        return ResponseEntity.ok(new DadosDetalheMedico(medicoAtual));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var medicoAtual = repository.getReferenceById(id);
        medicoAtual.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medicoAtual = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalheMedico(medicoAtual));
    }
}

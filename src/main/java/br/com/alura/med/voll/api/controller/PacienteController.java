package br.com.alura.med.voll.api.controller;

import br.com.alura.med.voll.api.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosPaciente dados){
       repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListaPaciente> listar(@PageableDefault(size = 5,sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListaPaciente::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        var pacienteAtual = repository.getReferenceById(id);
        pacienteAtual.excluir();
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizaPaciente dadosPaciente) {
        var medicoAtual = repository.getReferenceById(dadosPaciente.id());
        medicoAtual.atualizarInformacoes(dadosPaciente);
    }
}

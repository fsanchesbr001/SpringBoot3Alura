package br.com.alura.med.voll.api.controller;

import br.com.alura.med.voll.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosMedico medico){
        repository.save(new Medico(medico));
    }

    @GetMapping
    public Page<DadosListaMedico> listar(@PageableDefault(size = 5,sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListaMedico::new);
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizaMedico dadosMedico){
        var medicoAtual = repository.getReferenceById(dadosMedico.id());
        medicoAtual.atualizarInformacoes(dadosMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        var medicoAtual = repository.getReferenceById(id);
        medicoAtual.excluir();
    }
}

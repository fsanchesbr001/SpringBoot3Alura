package br.com.alura.med.voll.api.controller;

import br.com.alura.med.voll.api.domain.consulta.AgendarConsultas;
import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendarConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        var dadosConsulta = agenda.agendar(dados);
        return ResponseEntity.ok(dadosConsulta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        agenda.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        var consulta = agenda.buscarConsultaPorId(id);
        return ResponseEntity.ok(consulta);

    }

    @GetMapping()
    public ResponseEntity listarTodasConsultas(){
        var consulta = agenda.listarConsultas();
        return ResponseEntity.ok(consulta);

    }
}

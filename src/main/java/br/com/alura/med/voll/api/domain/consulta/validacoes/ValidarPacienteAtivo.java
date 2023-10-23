package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.ValidaConsultaException;
import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteAtivo implements ValidarAgendamentoConsulta{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteSelecionado = pacienteRepository.findById(dados.idPaciente()).get();
        if(!pacienteSelecionado.getAtivo()){
            throw new ValidaConsultaException("Paciente selecionado esta inativo.");
        }
    }
}

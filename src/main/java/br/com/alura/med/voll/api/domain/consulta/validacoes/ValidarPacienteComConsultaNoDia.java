package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.ValidaConsultaException;
import br.com.alura.med.voll.api.domain.consulta.ConsultaRepository;
import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteComConsultaNoDia implements ValidarAgendamentoConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsulta = repository.existsByPacienteIdAndDataBetween(dados.idPaciente()
                ,primeiroHorario,ultimoHorario);
        if(pacientePossuiOutraConsulta){
            throw new ValidaConsultaException("Paciente já tem outra consulta no dia");
        }
    }
}

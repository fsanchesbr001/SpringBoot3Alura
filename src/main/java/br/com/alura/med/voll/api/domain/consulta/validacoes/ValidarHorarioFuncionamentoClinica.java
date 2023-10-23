package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.ValidaConsultaException;
import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarHorarioFuncionamentoClinica implements ValidarAgendamentoConsulta{
    public void validar(DadosAgendamentoConsulta dados){
       var  dataConsulta = dados.data();
       var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
       var antesAbertura = dataConsulta.getHour() < 7;
       var aposFechamento = dataConsulta.getHour() > 18;

       if(domingo||antesAbertura||aposFechamento){
           throw new ValidaConsultaException("Horário de Consulta Incorreto");
       }
    }
}

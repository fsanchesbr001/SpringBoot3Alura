package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.ValidaConsultaException;
import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarAntecedenciaConsulta implements ValidarAgendamentoConsulta{
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var antecedencia = Duration.between(agora,dataConsulta).toMinutes();
        if(antecedencia<30){
            throw new ValidaConsultaException("Marcar consulta com antecedência mínima de 30 minutos.");
        }
    }
}

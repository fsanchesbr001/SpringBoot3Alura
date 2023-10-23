package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidarAgendamentoConsulta {
    void validar(DadosAgendamentoConsulta dados);
}

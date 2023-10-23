package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.ValidaConsultaException;
import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoAtivo implements ValidarAgendamentoConsulta{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados){
        if(dados.idMedico()==null){
            return;
        }
        var medicoSelecionado = medicoRepository.findById(dados.idMedico()).get();
        if(!medicoSelecionado.getAtivo()){
            throw new ValidaConsultaException("Medico selecionado esta inativo.");
        }
    }
}

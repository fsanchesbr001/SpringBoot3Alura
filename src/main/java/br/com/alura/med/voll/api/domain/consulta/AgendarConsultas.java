package br.com.alura.med.voll.api.domain.consulta;

import br.com.alura.med.voll.api.domain.ValidaConsultaException;
import br.com.alura.med.voll.api.domain.consulta.validacoes.ValidarAgendamentoConsulta;
import br.com.alura.med.voll.api.domain.medico.Medico;
import br.com.alura.med.voll.api.domain.medico.MedicoRepository;
import br.com.alura.med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendarConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidarAgendamentoConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidaConsultaException("Id do paciente não encontrado");
        }

        if(dados.idMedico()!=null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidaConsultaException("Id do médico não encontrado");
        }

        validadores.forEach(v->v.validar(dados));

        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null,medico,paciente,dados.data(),dados.ativo());
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta.getMedico().getId(),consulta.getPaciente().getId(),
                consulta.getData(),consulta.getAtivo());
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico()!=null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade()==null){
            throw new ValidaConsultaException("Especialidade não Informada!!!");
        }
        return medicoRepository.escolherMedicoAleatorioPorData(dados.especialidade(),dados.data());
    }

    public void excluir(Long idConsulta){
        var consulta = consultaRepository.existsById(idConsulta);
        if(!consulta){
            throw new ValidaConsultaException("Consulta não encontrada.");
        }
        consultaRepository.deleteById(idConsulta);
    }

    public DadosDetalhamentoConsulta buscarConsultaPorId(Long idConsulta){
        var consulta = consultaRepository.getReferenceById(idConsulta);
        if(consulta==null){
            throw new ValidaConsultaException("Consulta não encontrada.");
        }
        return new DadosDetalhamentoConsulta(consulta.getMedico().getId(),consulta.getPaciente().getId(),
                consulta.getData(),consulta.getAtivo());
    }

    public List<DadosDetalhamentoConsulta> listarConsultas(){
        var lista = consultaRepository.findAll();
        if(lista==null){
            throw new ValidaConsultaException("Lista de Consultas Vazia");
        }
        List<DadosDetalhamentoConsulta> saida = new ArrayList<DadosDetalhamentoConsulta>();
        for (Consulta item:lista ) {
            saida.add(new DadosDetalhamentoConsulta(item.getMedico().getId(),item.getPaciente().getId(),
                    item.getData(),item.getAtivo()));
        }
        return saida;
    }
}

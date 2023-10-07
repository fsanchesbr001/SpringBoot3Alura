package br.com.alura.med.voll.api.domain.medico;

import br.com.alura.med.voll.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Medico(DadosMedico medico) {
        this.id = medico.id();
        this.nome = medico.nome();
        this.especialidade = medico.especialidade();
        this.crm = medico.crm();
        this.email = medico.email();
        this.endereco = new Endereco(medico.endereco());
        this.telefone = medico.telefone();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizaMedico dadosMedico) {
        if(dadosMedico.nome()!=null){
            this.nome = dadosMedico.nome();
        }
        if(dadosMedico.telefone()!=null){
            this.telefone = dadosMedico.telefone();
        }
        if(dadosMedico.endereco()!=null){
            this.endereco.atualizarInformacoes(dadosMedico.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}

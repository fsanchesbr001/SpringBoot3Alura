package br.com.alura.med.voll.api.domain.paciente;

import br.com.alura.med.voll.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Paciente(DadosPaciente paciente) {
        this.id = paciente.id();
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.endereco = new Endereco(paciente.endereco());
        this.telefone = paciente.telefone();
        this.cpf = paciente.cpf();
        this.ativo = paciente.ativo();
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizaPaciente dadosPaciente) {
        if(dadosPaciente.nome()!=null){
            this.nome = dadosPaciente.nome();
        }
        if(dadosPaciente.telefone()!=null){
            this.telefone = dadosPaciente.telefone();
        }
        if(dadosPaciente.endereco()!=null){
            this.endereco.atualizarInformacoes(dadosPaciente.endereco());
        }

    }
}

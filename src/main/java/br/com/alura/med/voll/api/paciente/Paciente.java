package br.com.alura.med.voll.api.paciente;

import br.com.alura.med.voll.api.endereco.Endereco;
import br.com.alura.med.voll.api.medico.DadosMedico;
import br.com.alura.med.voll.api.medico.Especialidade;
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

    public Paciente(DadosPaciente paciente) {
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.endereco = new Endereco(paciente.endereco());
        this.telefone = paciente.telefone();
        this.cpf = paciente.cpf();
    }
}

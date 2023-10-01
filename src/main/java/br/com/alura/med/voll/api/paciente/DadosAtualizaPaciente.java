package br.com.alura.med.voll.api.paciente;

import br.com.alura.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPaciente(
    @NotNull
    Long id,
    String nome,
    String telefone,
    DadosEndereco endereco){
}

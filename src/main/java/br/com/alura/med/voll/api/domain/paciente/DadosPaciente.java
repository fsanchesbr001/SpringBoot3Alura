package br.com.alura.med.voll.api.domain.paciente;

import br.com.alura.med.voll.api.domain.endereco.DadosEndereco;

public record DadosPaciente(Long id, String nome, String email, String telefone, String cpf, DadosEndereco endereco, Boolean ativo) {
}

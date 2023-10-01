package br.com.alura.med.voll.api.paciente;

import br.com.alura.med.voll.api.endereco.DadosEndereco;

public record DadosPaciente(Long id,String nome, String email, String telefone, String cpf, DadosEndereco endereco, Boolean ativo) {
}

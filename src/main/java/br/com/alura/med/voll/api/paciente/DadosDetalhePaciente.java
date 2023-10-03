package br.com.alura.med.voll.api.paciente;

import br.com.alura.med.voll.api.endereco.Endereco;

public record DadosDetalhePaciente(Long id, String nome, String email, String telefone, String cpf,
                                   Endereco endereco, Boolean ativo) {
    public DadosDetalhePaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(),
                paciente.getCpf(), paciente.getEndereco(),paciente.getAtivo());
    }
}

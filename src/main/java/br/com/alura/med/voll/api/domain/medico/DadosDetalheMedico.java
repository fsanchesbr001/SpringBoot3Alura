package br.com.alura.med.voll.api.domain.medico;

import br.com.alura.med.voll.api.domain.endereco.Endereco;

public record DadosDetalheMedico(Long id, String nome, String email, String crm, Especialidade especialidade,
                                 Endereco endereco,String telefone, Boolean ativo) {
    public DadosDetalheMedico(Medico medico){
        this(medico.getId(),medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade(),
                medico.getEndereco(),medico.getTelefone(),medico.getAtivo());

    }
}

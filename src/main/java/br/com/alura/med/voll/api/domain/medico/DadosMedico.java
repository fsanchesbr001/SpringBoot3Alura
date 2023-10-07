package br.com.alura.med.voll.api.domain.medico;

import br.com.alura.med.voll.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosMedico(


        Long id,

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @Pattern(regexp = "\\d{9,11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco) {}

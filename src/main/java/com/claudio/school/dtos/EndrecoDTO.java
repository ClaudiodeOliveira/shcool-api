package com.claudio.school.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EndrecoDTO(
        @NotBlank(message = "O campo cep não pode ser nulo ou vazio.")
        String cep,

        String logradouro,

        String complemento,

        @NotNull(message = "O campo numéro não pode ser nulo ou vazio.")
        int numero,

        String bairro,

        String localidade) {
}

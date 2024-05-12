package com.claudio.school.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoDTO(
        @NotBlank(message = "O campo nome não pode ser nulo ou vazio.")
        String nome,

        @Email(message = "O campo email não está no formato correto.")
        @NotBlank(message = "O campo email não pode ser nulo ou vazio.")
        String email,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
        @NotNull(message = "O campo dataNascimento não pode ser nulo.")
        LocalDate dataNascimento,

        EndrecoDTO endreco,

        MatriculaDTO matricula) {
}

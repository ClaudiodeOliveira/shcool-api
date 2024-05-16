package com.claudio.school.dtos.aluno;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoUDTO(@NotNull(message = "O id do aluno não pode ser nulo.") Long id,

                        String nome,

                        String email,

                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East") LocalDate dataNascimento) {}

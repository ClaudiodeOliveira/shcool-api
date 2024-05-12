package com.claudio.school.dtos;

import jakarta.validation.constraints.NotBlank;

public record CursoPDTO(@NotBlank(message = "O nome do curso no pode ser nulo ou vazio.") String nome,
                        @NotBlank(message = "O curso deve possuir uma descrição.") String descricao, Integer duracao) {
}

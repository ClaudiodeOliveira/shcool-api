package com.claudio.school.dtos.curso;

import jakarta.validation.constraints.NotNull;

public record CursoUDTO(@NotNull(message = "O id do curso não pode ser nulo.") Long id,

                        String nome, String descricao, Integer duracao) {
}

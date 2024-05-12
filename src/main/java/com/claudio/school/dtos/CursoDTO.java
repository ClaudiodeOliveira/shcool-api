package com.claudio.school.dtos;

import jakarta.validation.constraints.NotBlank;

public record CursoDTO(@NotBlank(message = "O nome do curso no pode ser nulo ou vazio.") String nome) {
}

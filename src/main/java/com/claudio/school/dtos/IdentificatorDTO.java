package com.claudio.school.dtos;

import jakarta.validation.constraints.NotNull;

public record IdentificatorDTO(@NotNull(message = "O campo 'Id' é obrigatório") Long id) {
}

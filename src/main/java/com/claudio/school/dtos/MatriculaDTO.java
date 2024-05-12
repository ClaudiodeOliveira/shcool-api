package com.claudio.school.dtos;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record MatriculaDTO(
        @NotEmpty(message = "O aluno deve se matricular em pelo menos um curso") List<CursoDTO> cursos) {
}

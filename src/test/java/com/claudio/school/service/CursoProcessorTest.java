package com.claudio.school.service;

import com.claudio.school.exceptions.BusinessException;
import com.claudio.school.model.Curso;
import com.claudio.school.repository.CursoRepository;
import com.claudio.school.service.processor.CursoProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import properties.curso.CursoInstance;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Service Processor - Curso")
public class CursoProcessorTest {

    @Mock
    private CursoRepository cursoRepository;

    @Mock
    private Curso curso;

    @InjectMocks
    private CursoProcessor cursoProcessor;

    @BeforeEach
    public void init() {
        this.curso = CursoInstance.instace();
    }

    @Test
    void notExistsError() {
        when(this.cursoRepository.findByNome("Sistemas")).thenReturn(Optional.ofNullable(this.curso));
        Assertions.assertThrows(BusinessException.class, () -> this.cursoProcessor.notExists("Sistemas"));
    }

    @Test
    void notExistsSucess() {
        when(this.cursoRepository.findByNome("Sistemas")).thenReturn(Optional.empty());
        Assertions.assertDoesNotThrow(() -> this.cursoProcessor.notExists("Sistemas"));
    }

    @Test
    void existsNomeSucess() {
        when(this.cursoRepository.findByNome("Sistemas de Informações")).thenReturn(Optional.ofNullable(this.curso));
        Curso curso1 = this.cursoProcessor.exists("Sistemas de Informações");
        Assertions.assertEquals("Sistemas de Informações", curso1.getNome());
    }

    @Test
    void existsNomeError() {
        when(this.cursoRepository.findByNome("Sistemas")).thenReturn(Optional.ofNullable(this.curso));
        Assertions.assertThrows(BusinessException.class, () -> this.cursoProcessor.notExists("Sistemas"));
    }

    @Test
    void existsIdSucess() {
        when(this.cursoRepository.findById(1L)).thenReturn(Optional.ofNullable(this.curso));
        Curso curso1 = this.cursoProcessor.exists(1L);
        Assertions.assertEquals(1L, curso1.getId());
    }

    @Test
    void existsIdError() {
        when(this.cursoRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(BusinessException.class, () -> this.cursoProcessor.exists(1L));
    }

}

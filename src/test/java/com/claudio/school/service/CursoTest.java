package com.claudio.school.service;

import com.claudio.school.dtos.CursoPDTO;
import com.claudio.school.dtos.CursoUDTO;
import com.claudio.school.model.Curso;
import com.claudio.school.repository.CursoRepository;
import com.claudio.school.service.impl.CursoServiceImpl;
import com.claudio.school.service.processor.CursoProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import properties.curso.CursoInstance;
import properties.curso.CursoProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Service Implementation - Curso")
public class CursoTest extends CursoProperties {

    @Mock
    private Curso curso;

    @Mock
    private CursoPDTO cursoPDTO;

    @Mock
    private CursoUDTO cursoUDTO;

    @Mock
    private CursoProcessor cursoProcessor;

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoServiceImpl cursoService;

    @BeforeEach
    public void init() {
        this.curso = CursoInstance.instace();
    }

    @Test
    @DisplayName("Save Curso")
    void save() {
        when(this.cursoRepository.save(any())).thenReturn(this.curso);

        Curso response = this.cursoService.save(this.cursoPDTO);

        assertEquals(this.curso, response);
    }

}

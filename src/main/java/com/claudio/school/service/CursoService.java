package com.claudio.school.service;

import com.claudio.school.dtos.CursoPDTO;
import com.claudio.school.dtos.CursoUDTO;
import com.claudio.school.model.Curso;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CursoService {
    Curso save(CursoPDTO cursoPDTO);

    Curso findById(Long id);

    Page<Curso> findAll(int page, int size);

    List<Curso> saveAll(List<CursoPDTO> cursoPDTOS);

    void delete(Long id);

    Curso findByNome(String nome);

    Curso update(CursoUDTO cursoUDTO);
}

package com.claudio.school.service;

import com.claudio.school.dtos.AlunoDTO;
import com.claudio.school.model.Aluno;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AlunoService {
    Aluno save(AlunoDTO alunoDTO);

    Page<Aluno> findAll(int page, int size);

    Aluno findById(Long id);

    void delete(Long id);
}

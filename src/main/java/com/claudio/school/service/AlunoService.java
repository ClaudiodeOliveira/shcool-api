package com.claudio.school.service;

import com.claudio.school.dtos.aluno.AlunoDTO;
import com.claudio.school.dtos.aluno.AlunoHDTO;
import com.claudio.school.dtos.aluno.AlunoUDTO;
import com.claudio.school.model.Aluno;
import org.springframework.data.domain.Page;

public interface AlunoService {
    Aluno save(AlunoDTO alunoDTO);

    Page<Aluno> findAll(int page, int size, String[] sort);

    Aluno findById(Long id);

    void delete(Long id);

    AlunoHDTO addCurso(Long id, String nomeCurso);

    AlunoHDTO removeCurso(Long id, String nomeCurso);

    Aluno update(AlunoUDTO alunoUDTO);
}

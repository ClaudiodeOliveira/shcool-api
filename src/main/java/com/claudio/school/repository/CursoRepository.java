package com.claudio.school.repository;

import com.claudio.school.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Transactional(readOnly = true)
    Optional<Curso> findByNome(String nome);
}

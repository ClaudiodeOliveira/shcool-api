package com.claudio.school.repository;

import com.claudio.school.model.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UfRepository extends JpaRepository<UF, Long> {

    @Transactional(readOnly = true)
    Optional<UF> findBySigla(String sigla);
}

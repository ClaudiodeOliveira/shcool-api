package com.claudio.school.service;

import com.claudio.school.model.UF;

import java.util.List;

public interface UfService {
    List<UF> findAll();

    UF findBySigla(String sigla);
}

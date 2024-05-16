package com.claudio.school.service;

import com.claudio.school.dtos.cep.CepDTO;

public interface CepService {
    CepDTO find(String cep);
}

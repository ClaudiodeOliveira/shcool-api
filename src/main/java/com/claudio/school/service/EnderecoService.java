package com.claudio.school.service;

import com.claudio.school.model.Endereco;

public interface EnderecoService {
    Endereco findByCepApi( String cep) ;
}

package com.claudio.school.service.impl;

import com.claudio.school.dtos.CepDTO;
import com.claudio.school.http.CepApi;
import com.claudio.school.service.CepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Slf4j
@Service
@RequiredArgsConstructor
public class CepServiceImpl implements CepService {

    private final CepApi cepApi;

    @Override
    public CepDTO find(String cep) {
        log.info("Start - CepServiceImpl.find - CEP: {}", cep);

        cep = Normalizer.normalize(cep, Normalizer.Form.NFD).replaceAll("\\D", "");
        CepDTO cepDTO = this.cepApi.getCep(cep.replace("-", "").trim());

        log.info("End - CepServiceImpl.find - CEP: {}", cep);
        return cepDTO;
    }
}

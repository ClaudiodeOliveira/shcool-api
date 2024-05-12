package com.claudio.school.service.impl;

import com.claudio.school.exceptions.BusinessException;
import com.claudio.school.model.UF;
import com.claudio.school.repository.UfRepository;
import com.claudio.school.service.UfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UfServiceImpl implements UfService {

    private final UfRepository repository;

    @Override
    public List<UF> findAll() {
        log.info("Start - UfServiceImpl.findAll");
        List<UF> ufs = this.repository.findAll();
        log.info("End - UfServiceImpl.findAll");
        return ufs;
    }

    @Override
    public UF findBySigla(String sigla) {
        log.info("Start - UfServiceImpl.findBySigla - SIGLA: {}", sigla);
        Optional<UF> optional = this.repository.findBySigla(sigla);
        if (optional.isEmpty()) throw new BusinessException("UF não encotrada.");
        log.info("End - UfServiceImpl.findBySigla - UF: {}", optional.get());
        return optional.get();
    }
}

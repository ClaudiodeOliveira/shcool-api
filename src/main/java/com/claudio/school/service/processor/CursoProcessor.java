package com.claudio.school.service.processor;

import com.claudio.school.exceptions.BusinessException;
import com.claudio.school.model.Curso;
import com.claudio.school.repository.CursoRepository;
import com.claudio.school.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CursoProcessor {

    private final CursoRepository cursoRepository;

    public Curso exists(Long id) {
        log.info("Start - CursoProcessor.exists - ID: {}", id);
        Optional<Curso> optional = this.cursoRepository.findById(id);
        return optional.orElseThrow(() -> new BusinessException(MessageUtils.getMensagemValidacao("curso.nao.id.encontrado", id)));
    }

    public Curso exists(String nome) {
        log.info("Start - CursoProcessor.exists - NOME: {}", nome);
        Optional<Curso> optional = this.cursoRepository.findByNome(nome);
        return optional.orElseThrow(() -> new BusinessException(MessageUtils.getMensagemValidacao("curso.nao.nome.encontrado", nome)));
    }

    public void notExists(String nome) {
        log.info("Start - CursoProcessor.notExists - ID: {}", nome);
        Optional<Curso> optional = this.cursoRepository.findByNome(nome);
        if (optional.isPresent())
            throw new BusinessException(MessageUtils.getMensagemValidacao("curso.exists.nome", nome));
    }
}

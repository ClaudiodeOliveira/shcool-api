package com.claudio.school.service.impl;

import com.claudio.school.dtos.CursoPDTO;
import com.claudio.school.dtos.CursoUDTO;
import com.claudio.school.model.Curso;
import com.claudio.school.repository.CursoRepository;
import com.claudio.school.service.CursoService;
import com.claudio.school.service.processor.CursoProcessor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CursoProcessor cursoProcessor;

    private static final Logger log = LoggerFactory.getLogger(CursoServiceImpl.class);

    @Override
    public Curso save(CursoPDTO cursoPDTO) {
        log.info("Salvando curso");
        this.cursoProcessor.notExists(cursoPDTO.nome());
        Curso curso = Curso.builder().nome(cursoPDTO.nome()).descricao(cursoPDTO.descricao()).duracao(cursoPDTO.duracao()).build();
        curso = this.cursoRepository.save(curso);
        return curso;
    }

    @Override
    public Curso findById(Long id) {
        log.info("Buscando curso de ID: {}", id);
        return this.cursoProcessor.exists(id);
    }

    @Override
    public Page<Curso> findAll(int page, int size) {
        log.info("Buscando todos os cursos");
        return this.cursoRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Curso> saveAll(List<CursoPDTO> cursoPDTOS) {
        log.info("Salvado lista de cursos");
        List<Curso> cursos = new ArrayList<>();
        cursoPDTOS.forEach(curso -> cursos.add(this.save(curso)));
        return cursos;
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando curso com id {}", id);
        Curso curso = this.cursoProcessor.exists(id);
        this.cursoRepository.delete(curso);
    }

    @Override
    public Curso findByNome(String nome) {
        log.info("Buscando curso de nome: {}", nome);
        return this.cursoProcessor.exists(nome);
    }

    @Override
    public Curso update(CursoUDTO cursoUDTO) {
        log.info("Atualizando curso");
        Curso curso = this.findById(cursoUDTO.id());
        curso.setNome(Objects.nonNull(cursoUDTO.nome()) ? cursoUDTO.nome() : curso.getNome());
        curso.setDescricao(Objects.nonNull(cursoUDTO.descricao()) ? cursoUDTO.descricao() : curso.getDescricao());
        curso.setDuracao(Objects.nonNull(cursoUDTO.duracao()) ? cursoUDTO.duracao() : curso.getDuracao());
        curso = this.cursoRepository.save(curso);
        return curso;
    }


}

package com.claudio.school.service.impl;

import com.claudio.school.dtos.aluno.AlunoDTO;
import com.claudio.school.dtos.aluno.AlunoHDTO;
import com.claudio.school.dtos.aluno.AlunoUDTO;
import com.claudio.school.dtos.curso.CursoDTO;
import com.claudio.school.dtos.matricula.MatriculaDTO;
import com.claudio.school.exceptions.BusinessException;
import com.claudio.school.model.*;
import com.claudio.school.repository.AlunoRepository;
import com.claudio.school.service.AlunoService;
import com.claudio.school.service.CursoService;
import com.claudio.school.service.EnderecoService;
import com.claudio.school.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private static final Logger log = LoggerFactory.getLogger(AlunoServiceImpl.class);
    private final AlunoRepository alunoRepository;
    private final EnderecoService enderecoService;
    private final CursoService cursoService;

    @Override
    public Aluno save(AlunoDTO alunoDTO) {
        log.info("Salvando o aluno - {}", alunoDTO);
        Endereco endereco = this.enderecoService.findByCepApi(alunoDTO.endreco().cep());
        endereco.setNumero(alunoDTO.endreco().numero());
        endereco.setComplemento(alunoDTO.endreco().complemento());
        List<Curso> cursos = alunoDTO.matricula().cursos().stream().map(cursoDTO -> this.cursoService.findByNome(cursoDTO.nome())).toList();
        Matricula matricula = Matricula.builder().status(StatusMatricula.ATIVA).dataMatricula(LocalDate.now()).cursos(cursos).build();
        Aluno aluno = Aluno.builder().nome(alunoDTO.nome()).email(alunoDTO.email()).dataNascimento(alunoDTO.dataNascimento()).endereco(endereco).matricula(matricula).build();
        return this.alunoRepository.save(aluno);
    }

    @Override
    public Page<Aluno> findAll(int page, int size, String[] sort) {
        log.info("Buscando todos o aluno");
        String field = sort[0];
        String sortingDirection = sort[1];
        Sort.Direction direction = sortingDirection.equalsIgnoreCase("asc")? Sort.Direction.ASC: Sort.Direction.DESC;
        return this.alunoRepository.findAll(PageRequest.of(page, size, Sort.by(direction, field)));
    }

    @Override
    public Aluno findById(Long id) {
        log.info("Buscando o aluno pelo id");
        Optional<Aluno> optional = this.alunoRepository.findById(id);
        if (optional.isEmpty()) throw new BusinessException(MessageUtils.getMensagemValidacao("aluno.nao.encontrado", id));
        return optional.get();
    }

    @Override
    public void delete(Long id) {
        log.info("Deletar aluno pelo id");
        if (Objects.nonNull(this.findById(id))) this.alunoRepository.deleteById(id);
    }

    @Override
    public AlunoHDTO addCurso(Long id, String nomeCurso) {
        log.info("Matriculando o aluno no curso: {}", nomeCurso);
        Aluno aluno = this.findById(id);
        Curso curso = this.cursoService.findByNome(nomeCurso);
        Matricula matricula = aluno.getMatricula();
        if (matricula.getCursos().stream().anyMatch(cur -> cur.getId().equals(id)))
            throw new BusinessException(MessageUtils.getMensagemValidacao("aluno.ja.matriculado.no.curso", nomeCurso));
        aluno.getMatricula().getCursos().add(curso);
        aluno = this.alunoRepository.save(aluno);
        MatriculaDTO matriculaDTO = new MatriculaDTO(aluno.getMatricula().getCursos().stream().map(curs -> new CursoDTO(curs.getNome())).toList());
        return new AlunoHDTO(aluno.getNome(), aluno.getEmail(), aluno.getDataNascimento(), matriculaDTO);
    }

    @Override
    public AlunoHDTO removeCurso(Long id, String nomeCurso) {
        log.info("Removendo o aluno do curso: {}", nomeCurso);
        Aluno aluno = this.findById(id);
        Curso curso = this.cursoService.findByNome(nomeCurso);
        Matricula matricula = aluno.getMatricula();
        if (matricula.getCursos().stream().noneMatch(cur -> cur.getId().equals(curso.getId())))
            throw new BusinessException(MessageUtils.getMensagemValidacao("aluno.nao.matriculado.no.curso", nomeCurso));
        matricula.getCursos().removeIf(cur -> cur.getId().equals(curso.getId()));
        aluno = this.alunoRepository.save(aluno);
        MatriculaDTO matriculaDTO = new MatriculaDTO(aluno.getMatricula().getCursos().stream().map(curs -> new CursoDTO(curs.getNome())).toList());
        return new AlunoHDTO(aluno.getNome(), aluno.getEmail(), aluno.getDataNascimento(), matriculaDTO);
    }

    @Override
    public Aluno update(AlunoUDTO alunoUDTO) {
        log.info("Atualizando aluno: {}", alunoUDTO);
        Aluno aluno = this.findById(alunoUDTO.id());
        aluno.atualizar(alunoUDTO);
        return this.alunoRepository.save(aluno);
    }

}

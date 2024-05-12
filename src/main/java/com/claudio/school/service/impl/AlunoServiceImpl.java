package com.claudio.school.service.impl;

import com.claudio.school.dtos.AlunoDTO;
import com.claudio.school.dtos.CursoDTO;
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

        aluno = this.alunoRepository.save(aluno);

        return aluno;
    }

    @Override
    public Page<Aluno> findAll(int page, int size) {
        log.info("Buscando todos o aluno");
        return this.alunoRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Aluno findById(Long id) {
        log.info("Buscando o aluno pelo id");
        Optional<Aluno> optional = this.alunoRepository.findById(id);
        if (optional.isEmpty())
            throw new BusinessException(MessageUtils.getMensagemValidacao("aluno.nao.encontrado", id));
        return optional.get();
    }

    @Override
    public void delete(Long id) {
        log.info("Deletar aluno pelo id");
        if (Objects.nonNull(this.findById(id))) this.alunoRepository.deleteById(id);
    }
}

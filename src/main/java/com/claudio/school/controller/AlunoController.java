package com.claudio.school.controller;


import com.claudio.school.dtos.AlunoDTO;
import com.claudio.school.exceptions.handler.ApiErrorResponse;
import com.claudio.school.model.Aluno;
import com.claudio.school.service.AlunoService;
import com.claudio.school.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@Tag(name = "Aluno", description = "Aluno School")
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @Operation(summary = "Cadastrar Aluno", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description =
            "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
            "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
            "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}),})
    @PostMapping
    @CacheEvict(value = "aluno", allEntries = true)
    public ResponseEntity<Response<Aluno>> save(@Valid @RequestBody AlunoDTO alunoDTO) {
        log.info("Start - AlunoController.save - Aluno: {}", alunoDTO);
        Response<Aluno> response = new Response<>();
        Aluno aluno = this.alunoService.save(alunoDTO);
        response.setData(aluno);
        log.info("End - AlunoController.save - Aluno: {}", aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Buscar Todos Alunos", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
            description = "Operação concluída com Sucesso.", useReturnTypeSchema = true),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição Inválida.", content =
                    {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class)))}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno ao realizar operação.", content
                    = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class)))}),})
    @GetMapping
    @Cacheable("aluno")
    public ResponseEntity<Response<Page<Aluno>>> findAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                         @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        log.info("Start - AlunoController.findAll");
        Response<Page<Aluno>> response = new Response<>();
        Page<Aluno> alunos = this.alunoService.findAll(page, size);
        response.setData(alunos);
        log.info("End - AlunoController.findAll");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Buscar Aluno Pelo ID", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
            description = "Operação concluída com Sucesso.", useReturnTypeSchema = true),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição Inválida.", content =
                    {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class)))}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno ao realizar operação.", content
                    = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class)))}),})
    @Cacheable("aluno")
    @GetMapping("/{id}")
    public ResponseEntity<Response<Aluno>> findById(@PathVariable("id") Long id) {
        log.info("Start - AlunoController.findById -  ID: {}", id);
        Response<Aluno> response = new Response<>();
        response.setData(this.alunoService.findById(id));
        log.info("End - AlunoController.findById -  Aluno: {}", response.getData());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Deletar Aluno Pelo ID", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
            description = "Operação concluída com Sucesso.", useReturnTypeSchema = true),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição Inválida.", content =
                    {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class)))}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno ao realizar operação.", content
                    = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class)))}),})
    @DeleteMapping("/{id}")
    @CacheEvict(value = "aluno", allEntries = true)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        log.info("Start - AlunoController.delete -  ID: {}", id);
        this.alunoService.delete(id);
        log.info("End - AlunoController.delete");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

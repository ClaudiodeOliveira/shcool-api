package com.claudio.school.controller;


import com.claudio.school.dtos.CursoPDTO;
import com.claudio.school.dtos.CursoUDTO;
import com.claudio.school.exceptions.handler.ApiErrorResponse;
import com.claudio.school.model.Curso;
import com.claudio.school.service.CursoService;
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
@Tag(name = "Curso", description = "Curso School")
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @Operation(summary = "Cadastrar Curso", responses =
            {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description =
                    "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
                    "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
                    "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}),})
    @PostMapping
    @CacheEvict(value = "curso", allEntries = true)
    public ResponseEntity<Response<Curso>> save(@Valid @RequestBody CursoPDTO cursoPDTO) {
        log.info("Start - CursoController.save -  Curso: {}", cursoPDTO);
        Response<Curso> response = new Response<>();
        Curso curso = this.cursoService.save(cursoPDTO);
        response.setData(curso);
        log.info("End - CursoController.save -  Curso: {}", cursoPDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Cadastrar Cursos", responses =
            {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description =
                    "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
                    "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
                    "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}),})
    @PostMapping("/all")
    @CacheEvict(value = "curso", allEntries = true)
    public ResponseEntity<Response<List<Curso>>> saveAll(@Valid @RequestBody List<CursoPDTO> cursoPDTOS) {
        log.info("Start - CursoController.saveAll -  Cursos: {}", cursoPDTOS);
        Response<List<Curso>> response = new Response<>();
        List<Curso> cursos = this.cursoService.saveAll(cursoPDTOS);
        response.setData(cursos);
        log.info("End - CursoController.saveAll -  Cursos: {}", cursoPDTOS);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Atualizar Curso", responses =
            {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description =
                    "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
                    "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
                    "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}),})
    @PutMapping
    public ResponseEntity<Response<Curso>> update(@Valid @RequestBody CursoUDTO cursoUDTO) {
        log.info("Start - CursoController.update");
        Response<Curso> response = new Response<>();
        Curso curso = this.cursoService.update(cursoUDTO);
        response.setData(curso);
        log.info("End - CursoController.update");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Buscar Curso", responses =
            {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description =
                    "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
                    "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
                    "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}),})
    @GetMapping("/{id}")
    @Cacheable("curso")
    public ResponseEntity<Response<Curso>> findById(@PathVariable("id") Long id) {
        log.info("Start - CursoController.findById - ID: {}", id);
        Response<Curso> response = new Response<>();
        Curso curso = this.cursoService.findById(id);
        response.setData(curso);
        log.info("End - CursoController.findById - ID: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Buscar Cursos", responses =
            {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description =
                    "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
                    "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
                    "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
            @Schema(implementation = ApiErrorResponse.class)))}),})
    @GetMapping
    @Cacheable("curso")
    public ResponseEntity<Response<Page<Curso>>> findAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                         @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        log.info("Start - CursoController.findAll");
        Response<Page<Curso>> response = new Response<>();
        Page<Curso> cursos = this.cursoService.findAll(page, size);
        response.setData(cursos);
        log.info("End - CursoController.findAll");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "curso", allEntries = true)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        log.info("Start - CursoController.delete - ID: {}", id);
        this.cursoService.delete(id);
        log.info("End - CursoController.delete - ID: {}", id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

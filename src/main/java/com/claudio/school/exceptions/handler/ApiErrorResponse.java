package com.claudio.school.exceptions.handler;


import lombok.*;

@Getter
@Builder
public class ApiErrorResponse {

    private String id;
    private String status;
    private String codigo;
    private String titulo;
    private String detalhe;
    private Metadado metadado;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Metadado{

        private String idTransacao;
        private String nmServico;
        private String url;
        private String timestamp;
    }
}
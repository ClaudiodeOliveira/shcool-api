package com.claudio.school.dtos.cep;


public record CepDTO(String cep, String logradouro, String complemento, String bairro, String localidade,
                     String uf) {
}
package com.claudio.school.http;

import com.claudio.school.dtos.cep.CepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "CepApi", name = "API", url = "https://viacep.com.br/ws")
public interface CepApi {

    @GetMapping("/{cep}/json/")
    CepDTO getCep(@PathVariable("cep") String cep);
}

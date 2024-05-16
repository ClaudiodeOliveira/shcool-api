package com.claudio.school.service.impl;

import com.claudio.school.dtos.cep.CepDTO;
import com.claudio.school.exceptions.BusinessException;
import com.claudio.school.model.Endereco;
import com.claudio.school.model.UF;
import com.claudio.school.service.CepService;
import com.claudio.school.service.EnderecoService;
import com.claudio.school.service.UfService;
import com.claudio.school.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private static final Logger log = LoggerFactory.getLogger(EnderecoServiceImpl.class);
    private final CepService cepService;
    private final UfService ufService;

    @Override
    public Endereco findByCepApi(String cep) {
        log.info("Buscando informação do endereço pelo cep");
        try {
            if (cep.isBlank()) throw new Exception(MessageUtils.getMensagemValidacao("endereco.cep.invalido"));
            CepDTO cepDTO = this.cepService.find(cep);
            UF uf = this.ufService.findBySigla(cepDTO.uf());
            return Endereco.builder().cep(cepDTO.cep()).uf(uf).bairro(cepDTO.bairro()).localidade(cepDTO.localidade()).logradouro(cepDTO.logradouro()).build();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}

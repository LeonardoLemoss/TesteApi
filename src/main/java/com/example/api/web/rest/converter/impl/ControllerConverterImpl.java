package com.example.api.web.rest.converter.impl;

import org.springframework.stereotype.Component;

import com.example.api.domain.CorreirosCep;
import com.example.api.integration.data.CepRestResponse;
import com.example.api.web.rest.converter.ControllerConverter;

@Component
public class ControllerConverterImpl implements ControllerConverter{

	@Override
	public CorreirosCep converterController(CepRestResponse responseRest) {
		return CorreirosCep.builder()
				 .cep(responseRest.getCep())
	             .logradouro(responseRest.getLogradouro())
	             .bairro(responseRest.getBairro())
	             .complemento(responseRest.getComplemento())
	             .localidade(responseRest.getLocalidade())
	             .build();
	}

}

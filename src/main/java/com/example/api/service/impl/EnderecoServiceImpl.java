package com.example.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.CorreirosCep;
import com.example.api.integration.CEPintegration;
import com.example.api.integration.data.CepRestResponse;
import com.example.api.service.EnderecoService;
import com.example.api.web.rest.converter.ControllerConverter;

@Service
public class EnderecoServiceImpl implements EnderecoService{

    @Autowired
    private ControllerConverter converter;
    
    @Autowired
    private CEPintegration cepIntegration;

	
	@Override
	public CorreirosCep buscarCep(String cep) {
		
		 CepRestResponse responseRest = cepIntegration.buscarCep(cep);
		 
		 CorreirosCep response = converter.converterController(responseRest);
		
		return response;
	}

}

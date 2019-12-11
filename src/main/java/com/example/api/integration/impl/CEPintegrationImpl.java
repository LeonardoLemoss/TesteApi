package com.example.api.integration.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.api.domain.CorreirosCep;
import com.example.api.integration.CEPintegration;
import com.example.api.integration.data.CepRestResponse;
import com.example.api.web.rest.converter.ControllerConverter;

@Service
public class CEPintegrationImpl implements CEPintegration{

	@Autowired
	RestTemplate restTemplate;

	 
	@Override
	public CepRestResponse buscarCep(String cep) {

	String uri = "http://viacep.com.br/ws/{cep}/json/";
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("cep", cep);
	    return restTemplate.getForObject(uri, CepRestResponse.class, params);
	}

}

package com.example.api.integration;

import com.example.api.integration.data.CepRestResponse;

public interface CEPintegration {

	CepRestResponse buscarCep(String cep);
	
}

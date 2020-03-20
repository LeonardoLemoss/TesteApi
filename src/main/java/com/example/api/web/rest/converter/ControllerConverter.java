package com.example.api.web.rest.converter;

import com.example.api.domain.CorreirosCep;
import com.example.api.integration.data.CepRestResponse;

public interface ControllerConverter {

	CorreirosCep converterController(CepRestResponse responseRest);
	
}

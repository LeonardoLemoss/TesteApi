package com.example.api.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.api.domain.CorreirosCep;
import com.example.api.repository.EnderecoRepository;
import com.example.api.service.EnderecoService;

@Service
public class EnderecoController {

	private EnderecoService service;
	
	@GetMapping(value="/getCep/{cep}")
	public ResponseEntity<CorreirosCep> ReceberCep(@PathVariable(name = "cep") String cep) {
		
		CorreirosCep response = service.buscarCep(cep);
	    
		return new  ResponseEntity<CorreirosCep>(response, HttpStatus.OK);
	}
	
	
	
}

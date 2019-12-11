package com.example.api.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.CorreirosCep;
import com.example.api.execption.InvalidCepExecption;
import com.example.api.repository.EnderecoRepository;
import com.example.api.service.CustomerService;
import com.example.api.service.EnderecoService;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	@Autowired
	public EnderecoController(EnderecoService service) {
		this.service = service;
	}

	@GetMapping(value="/getCep/{cep}")
	public ResponseEntity<CorreirosCep> ReceberCep(@PathVariable(name = "cep") String cep) throws InvalidCepExecption{
		
		CorreirosCep response = service.buscarCep(cep);
	    
		return new  ResponseEntity<CorreirosCep>(response, HttpStatus.OK);
	}
	
	
}

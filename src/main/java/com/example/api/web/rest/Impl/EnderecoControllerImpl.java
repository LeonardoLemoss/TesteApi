package com.example.api.web.rest.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.CorreirosCep;
import com.example.api.execption.InvalidCepExecption;
import com.example.api.service.EnderecoService;
import com.example.api.web.rest.EnderecoController;


@RestController
public class EnderecoControllerImpl implements EnderecoController{

	@Autowired
	private EnderecoService service;
	
	@Autowired
	public EnderecoControllerImpl(EnderecoService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/getCep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<CorreirosCep> ReceberCep(@PathVariable(name = "cep") String cep) throws InvalidCepExecption{
		
		CorreirosCep response = service.buscarCep(cep);
	    
		return new  ResponseEntity<CorreirosCep>(response, HttpStatus.OK);
	}
	
}

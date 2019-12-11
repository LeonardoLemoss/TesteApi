package com.example.api.web.rest;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value="Endereco API")
@RestController
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	@Autowired
	public EnderecoController(EnderecoService service) {
		this.service = service;
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna as informaçoes do cep informado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@RequestMapping(value = "/getCep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<CorreirosCep> ReceberCep(@PathVariable(name = "cep") String cep) throws InvalidCepExecption{
		
		CorreirosCep response = service.buscarCep(cep);
	    
		return new  ResponseEntity<CorreirosCep>(response, HttpStatus.OK);
	}
	
	
}

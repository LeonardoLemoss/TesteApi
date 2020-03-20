package com.example.api.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.api.domain.CorreirosCep;
import com.example.api.execption.InvalidCepExecption;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value="Endereco API")
public interface EnderecoController {

	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna as informaçoes do cep informado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<CorreirosCep> ReceberCep(@PathVariable(name = "cep") String cep)
			throws InvalidCepExecption;
	
	
}

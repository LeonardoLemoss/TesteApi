package com.example.api.execption;

import org.springframework.http.HttpStatus;

public class NomeDuplicadoException extends ErroExceptions{
	
	public NomeDuplicadoException() {
        
		super(409,"duplicidade erro");
		super.setCode(409);
		super.setHttpStatus(HttpStatus.CONFLICT);
		super.setMensagemUsuario("nome Já Existe.");
		super.setOrigem("validaNome");
	
	}
	
	
}

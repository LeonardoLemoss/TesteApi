package com.example.api.execption;

import org.springframework.http.HttpStatus;

public class EmailDuplicadoException extends ErroExceptions{

	public EmailDuplicadoException() {
        
		super(409,"duplicidade erro");
		super.setCode(409);
		super.setHttpStatus(HttpStatus.CONFLICT);
		super.setMensagemUsuario("Renavam Já Existe.");
		super.setOrigem("validaRenavam");
	
	}
	
	
}

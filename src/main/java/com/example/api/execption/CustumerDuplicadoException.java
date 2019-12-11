package com.example.api.execption;

import org.springframework.http.HttpStatus;

public class CustumerDuplicadoException  extends ErroExceptions{

	public CustumerDuplicadoException() {
		super(409, "Custumer Duplicado");
		super.setHttpStatus(HttpStatus.CONFLICT);
		super.setMensagemUsuario("Custumer Já Existe.");
		super.setOrigem("altera");
	}
}

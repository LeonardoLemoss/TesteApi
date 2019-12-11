package com.example.api.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCepExecption extends RuntimeException{

	public InvalidCepExecption(String exception) {
		super(exception);
	}
	
}

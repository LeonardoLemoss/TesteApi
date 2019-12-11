package com.example.api.execption;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustumaizarExecption extends ResponseEntityExceptionHandler  {

	
	@ExceptionHandler(Exception.class) 
	public final ResponseEntity<Execption> handleAllExceptions(Exception ex, WebRequest request){
		Execption execeptuionsResponse = new Execption(
				new Date(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(execeptuionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(InvalidCepExecption.class) 
	public final ResponseEntity<Execption> handleBadRequestExceptions(Exception ex, WebRequest request){
		Execption execeptuionsResponse = new Execption(
				new Date(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(execeptuionsResponse, HttpStatus.BAD_REQUEST);
		
	}
}

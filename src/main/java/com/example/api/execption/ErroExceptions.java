package com.example.api.execption;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErroExceptions extends Throwable{

	private Integer code;
	private HttpStatus httpStatus;
	private String mensagemUsuario;
	private String origem;
	
	public ErroExceptions(Integer code,String message, HttpStatus httpStatus, String mensagemUsuario,String origem) {
        super(message);
        this.mensagemUsuario = mensagemUsuario;
        this.code = code;
        this.origem = origem;
    }
	
	 public ErroExceptions(Integer code, String message) {
	        super(message);
	        this.code = code;
	    }
}

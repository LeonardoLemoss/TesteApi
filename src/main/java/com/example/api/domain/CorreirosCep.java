package com.example.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorreirosCep {

	  private String cep;
	    
	  private String logradouro;
	    
	  private String bairro;

	  private String complemento;
	    
	  private String localidade;

	  
}

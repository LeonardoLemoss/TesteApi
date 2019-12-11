package com.example.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "CEP")
public class CorreirosCep {

	  @ApiModelProperty(value = "")
	  private String cep;
	    
	  private String logradouro;
	    
	  private String bairro;

	  private String complemento;
	    
	  private String localidade;

	  
}

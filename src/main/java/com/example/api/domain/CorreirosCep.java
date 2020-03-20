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

	  @ApiModelProperty(value = "CEP")
	  private String cep;
	  
	  @ApiModelProperty(value = "lOGRADOURO")
	  private String logradouro;
	  
	  @ApiModelProperty(value = "BAIRRO")
	  private String bairro;

	  @ApiModelProperty(value = "COMPLEMENTO")
	  private String complemento;
	    
	  @ApiModelProperty(value = "LOCALIDADE")
	  private String localidade;

	  
}

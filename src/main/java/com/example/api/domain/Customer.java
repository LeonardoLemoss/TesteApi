package com.example.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Customer")
public class Customer {

	@ApiModelProperty(value = "Código do cliente")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ApiModelProperty(value = "nome do cliente")
	@Column(nullable = false)
	@NotEmpty
	private String name;

	@ApiModelProperty(value = "email do cliente")
	@Column(nullable = false)
	@NotEmpty
	@Email
	private String email;

	
}

package com.example.api.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.execption.ErroExceptions;
import com.example.api.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Customer")
public interface CustomerController {

	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Cadastro realizado com sucesso"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Erro interno"),
		})
	public Customer cadastra(@Valid @RequestBody Customer customer)throws ErroExceptions;
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Edição realizada com sucesso"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Erro interno"),
		})
	public  ResponseEntity<Customer> edita
	(@PathVariable(value = "id") long id, @Valid @RequestBody Customer newCustomer);
	
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Deleção realizada com sucesso"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Erro interno"),
		})
	public ResponseEntity<Customer>deleta(@PathVariable(value = "id") Long id);
		
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Listagem realizada com sucesso"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Erro interno"),
		})
	public List<Customer> findAll();
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Lista o cliente por id"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Erro interno"),
		})
	public Customer findById(@PathVariable Long id);

}

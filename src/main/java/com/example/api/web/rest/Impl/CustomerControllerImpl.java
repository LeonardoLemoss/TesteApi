package com.example.api.web.rest.Impl;

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
import com.example.api.web.rest.CustomerController;


@RestController
@RequestMapping("/customers")
public class CustomerControllerImpl implements CustomerController{

	@Autowired
	private CustomerService service;

	
	@RequestMapping(value = "/cadastra", method =  RequestMethod.POST, produces="application/json")
	public Customer cadastra(@Valid @RequestBody Customer customer) throws ErroExceptions
	{
		try {
			
			return service.salva(customer);
		
		} catch (ErroExceptions e) {
			
			throw new ErroExceptions(e.getCode(),
					e.getMessage(), HttpStatus.BAD_REQUEST, e.getMensagemUsuario(), e.getOrigem());
		}
	}
	
	@RequestMapping(value = "/edita/{id}", method =  RequestMethod.PUT, produces="application/json")
	public  ResponseEntity<Customer> edita(@PathVariable(value = "id") long id, @Valid @RequestBody Customer newCustomer)
	{
		Optional<Customer> customer = service.findById(id);

		if(customer.isPresent()){
			Customer c = customer.get();
			c.setName(newCustomer.getName());
			c.setEmail(newCustomer.getEmail());

			service.save(c);

			return new ResponseEntity<Customer>(c, HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE,produces="application/json")
	public ResponseEntity<Customer>deleta(@PathVariable(value = "id") Long id) {
		
		Optional<Customer> custumer = service.findById(id);
        
		if(custumer.isPresent()){
            service.delete(custumer.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}
	
}

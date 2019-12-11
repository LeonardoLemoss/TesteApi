package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.execption.CustumerDuplicadoException;
import com.example.api.execption.EmailDuplicadoException;
import com.example.api.execption.ErroExceptions;
import com.example.api.execption.NomeDuplicadoException;
import com.example.api.repository.CustomerRepository;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;


import static org.apache.logging.log4j.util.Strings.isNotEmpty;


@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer salva(Customer customer)throws ErroExceptions {
		
		verificaDuplicidade(customer);
		
		return repository.save(customer);
	}

	public Customer edita(Customer customer, Long id)throws ErroExceptions{
		Optional<Customer> optional =
				repository.findById(id);
		
		if(optional.isPresent()) {
			
			Customer customer2 = optional.get();
			
			int custumerJaEncontrado =
					repository.verificaDuplicidade(
							customer.getName(),
							customer.getEmail(),
							customer.getId());
							
			if(custumerJaEncontrado > 0) {
				throw new CustumerDuplicadoException();
			}
		}
		
		return repository.save(customer);
	}

	public void save(Customer c) {
		repository.save(c);

	}

	public void delete(Customer customer) {
		repository.delete(customer);
	}
	
	private void verificaDuplicidade(Customer customer)throws NomeDuplicadoException, EmailDuplicadoException {
		
		if(isNotEmpty(customer.getName())){
			verificaDuplicidade(customer.getName());
		}
		
		if(isNotEmpty(customer.getEmail())){
			verificaDuplicidadeEmail(customer.getEmail());
		}
		
	}

	private void verificaDuplicidadeEmail(String email)throws EmailDuplicadoException {
		if(repository.findByEmail(email).isPresent())
			throw new EmailDuplicadoException();
		
	}

	private void verificaDuplicidade(String name) throws NomeDuplicadoException {
		if(repository.findByName(name).isPresent())
			throw new NomeDuplicadoException();
	}

}

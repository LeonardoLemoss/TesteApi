package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

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

	public Customer salva(Customer customer) {
		return repository.save(customer);
	}

	public Customer edita(Customer customer) {
		return repository.save(customer);
	}

	public void save(Customer c) {
		repository.save(c);

	}

	public void delete(Customer customer) {
		repository.delete(customer);
	}

}

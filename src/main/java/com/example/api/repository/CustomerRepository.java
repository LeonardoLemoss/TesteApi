package com.example.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.api.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findAllByOrderByNameAsc();

	Optional<Customer> findByName(String name);

	Optional<Customer> findByEmail(String email);

	@Query("select count(v) as existente from Customer"
			+ " v where (v.name = :name or v.email = :email) and v.id != :id")
	int verificaDuplicidade(String name, String email, Long id);


}

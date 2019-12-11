package com.example.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.api.domain.CorreirosCep;

public interface EnderecoRepository extends CrudRepository<CorreirosCep, Long> {

	
}

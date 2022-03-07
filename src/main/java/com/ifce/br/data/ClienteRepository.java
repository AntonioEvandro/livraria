package com.ifce.br.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifce.br.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
}

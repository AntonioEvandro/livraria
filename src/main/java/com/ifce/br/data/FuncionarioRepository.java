package com.ifce.br.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifce.br.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}

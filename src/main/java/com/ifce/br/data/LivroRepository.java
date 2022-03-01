package com.ifce.br.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifce.br.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

}

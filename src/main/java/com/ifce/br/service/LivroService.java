package com.ifce.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifce.br.data.LivroRepository;
import com.ifce.br.model.Livro;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void cadastrarLivro(Livro livro) {
		livroRepository.save(livro);
	}
}

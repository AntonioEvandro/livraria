package com.ifce.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifce.br.model.Livro;
import com.ifce.br.service.LivroService;

@Controller
public class livroController {

	@GetMapping("/inicio")
	public String inicio() {
		return "Inicio";
	}
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping("/cadastro/livro")
	public String cadastroLivro() {
		return "Cadastro_livro";
	}
	
	@PostMapping("cadastro/livro/salvar")
	public String cadastrarLivro(Livro livro) {
		System.out.println(livro.getAutor());
		livroService.cadastrarLivro(livro);
		return "Inicio";
	}
	@GetMapping("/listar/livro")
	public String listarlivro(Model model) {
		model.addAttribute("livro", livroService.listarLivro());
		return "Listagem_livro";
	}
}


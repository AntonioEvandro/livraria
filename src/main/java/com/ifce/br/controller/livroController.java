package com.ifce.br.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String cadastroLivro(Model model) {
		model.addAttribute("livro", new Livro());
		return "Cadastro_livro";
	}
	
	@PostMapping("cadastro/livro/salvar")
	public String cadastrarLivro(Livro livro, @RequestParam(value="imagem") MultipartFile imagem) {
		//System.out.println(livro.getAutor());
		livroService.cadastrarLivro(livro, imagem);
		return "Sucesso";
	}
	@GetMapping("/listar/livro")
	public String listarlivro(Model model) {
		model.addAttribute("livro", livroService.listarLivro());
		return "Listagem_livro";
	}
	@GetMapping("/excluir/livro/{codigo}")
	public String excluirLivro(@PathVariable Long codigo) {
		livroService.excluir(codigo);
		return "redirect:/listar/livro";
	}
	@GetMapping("/atualizar/livro/{codigo}")
	public String atualizarLivro(@PathVariable Long codigo, Model model) {
		Optional<Livro> livro = livroService.retornarPeloId(codigo);
		model.addAttribute("livro", livro);
		return "Cadastro_livro";
	}
	
}


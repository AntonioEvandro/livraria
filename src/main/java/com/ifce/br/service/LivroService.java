package com.ifce.br.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ifce.br.data.LivroRepository;
import com.ifce.br.model.Livro;
import com.ifce.br.util.LivrariaFileUtils;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void cadastrarLivro(Livro livro, MultipartFile imagem) {
		String caminho = "imagens/" + livro.getTitulo() + ".png";
		LivrariaFileUtils.salvarImagem(caminho, imagem);
		livroRepository.save(livro);
	}
	public Iterable<Livro>listarLivro(){
		return livroRepository.findAll();
	}
	public void excluir(Long id) {
		livroRepository.deleteById(id);
	}
	public Optional<Livro> retornarPeloId(Long codigo) {
		return livroRepository.findById(codigo);
	}
}

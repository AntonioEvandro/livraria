package com.ifce.br.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ifce.br.data.FuncionarioRepository;
import com.ifce.br.model.Funcionario;
import com.ifce.br.util.LivrariaFileUtils;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funciRepo;
	
	public void cadastrarFunci(Funcionario funci, MultipartFile imagem) {
		String caminho = "imagens/"+funci.getNome()+".png";
		LivrariaFileUtils.salvarImagem(caminho, imagem);
		funciRepo.save(funci);
	}
	public Iterable<Funcionario> listarFunci() {
		return funciRepo.findAll();
	}
	public void excluir(Long id) {
		funciRepo.deleteById(id);
	}
	public Optional<Funcionario> retornarFunPeloId(Long codigo) {
		return funciRepo.findById(codigo);
	}
}

package com.ifce.br.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ifce.br.data.ClienteRepository;
import com.ifce.br.model.Cliente;
import com.ifce.br.util.LivrariaFileUtils;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
		
	public void cadastrarCliente(Cliente cliente, MultipartFile imagem) {
		String caminho = "imagens/"+cliente.getNome()+".png";
		LivrariaFileUtils.salvarImagem(caminho, imagem);
		clienteRepository.save(cliente);
	}
	public Iterable<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
	public Optional<Cliente> retornarCliPeloId(Long codigo) {
		return clienteRepository.findById(codigo);
	}
}

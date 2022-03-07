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

import com.ifce.br.model.Cliente;
import com.ifce.br.service.ClienteService;

@Controller
public class clienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cadastro/cliente")
	public String cadastroCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "Cadastro_cliente";
	}
	
	@PostMapping("cadastro/cliente/salvar")
	public String cadastrarCliente(Cliente cliente, @RequestParam(value="imagem") MultipartFile imagem) {
		clienteService.cadastrarCliente(cliente, imagem);
		return "Sucesso";
	}
	@GetMapping("/listar/cliente")
	public String listarcliente(Model model) {
		model.addAttribute("cliente", clienteService.listarCliente());
		return "Listagem_cliente";
	}
	@GetMapping("/excluir/cliente/{codigo}")
	public String excluirCliente(@PathVariable Long codigo) {
		clienteService.excluir(codigo);
		return "redirect:/listar/cliente";
	}
	@GetMapping("/atualizar/cliente/{codigo}")
	public String atualizarCliente(@PathVariable Long codigo, Model model) {
		Optional<Cliente> cliente = clienteService.retornarCliPeloId(codigo);
		model.addAttribute("cliente", cliente);
		return "Cadastro_cliente";
	}
	
}

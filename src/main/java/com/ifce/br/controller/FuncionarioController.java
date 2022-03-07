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

import com.ifce.br.model.Funcionario;
import com.ifce.br.service.FuncionarioService;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funciService;
	
	@GetMapping("/cadastro/funcionario")
	public String cadastroCliente(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "Cadastro_funcionario";
	}

	@PostMapping("cadastro/funcionario/salvar")
	public String cadastrarFunci(Funcionario funci, @RequestParam(value="imagem") MultipartFile imagem) {
		funciService.cadastrarFunci(funci, imagem);
		return "Sucesso";
	}
	@GetMapping("/listar/funcionario")
	public String listarfunci(Model model) {
		model.addAttribute("funcionario", funciService.listarFunci());
		return "Listagem_funcionario";
	}
	@GetMapping("/excluir/funcionario/{codigo}")
	public String excluirFunci(@PathVariable Long codigo, Model model) {
		funciService.excluir(codigo);
		return "redirect:/listar/funcionario";
	}
	@GetMapping("/atualizar/funcionario/{codigo}")
	public String atualizarFunci(@PathVariable Long codigo, Model model) {
		Optional<Funcionario> funcionario = funciService.retornarFunPeloId(codigo);
		model.addAttribute("funcionario", funcionario);
		return "Cadastro_funcionario";
		
	}
}

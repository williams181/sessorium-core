package br.com.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Escola;

@Controller
public class EscolaController {

	@GetMapping
	public String exibirFomrCadastroEscola(){
		return "";
		
	}
	@PostMapping
	public String cadastrarEscola(Escola escola) {
		return "";
	}
}

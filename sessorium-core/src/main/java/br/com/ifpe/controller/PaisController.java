package br.com.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Pais;

@Controller
public class PaisController {

	@GetMapping
	public String exibirFomrCadastroPais(){
		return "";
		
	}
	@PostMapping
	public String cadastrarPais(Pais pais) {
		return "";
	}
}

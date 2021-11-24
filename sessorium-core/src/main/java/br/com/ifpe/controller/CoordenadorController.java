package br.com.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Coordenador;

@Controller
public class CoordenadorController {
	
	@GetMapping
	public String exibirFomrCadastroCoordenador(){
		return "";
		
	}
	@PostMapping
	public String cadastrarCoordenador(Coordenador coordenador) {
		return "";
	}

}

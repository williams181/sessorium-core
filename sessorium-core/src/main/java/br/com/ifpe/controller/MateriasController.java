package br.com.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Materias;

@Controller
public class MateriasController {
	
	@GetMapping
	public String exibirFomrCadastroMaterias(){
		return "";
		
	}
	@PostMapping
	public String cadastrarMaterias(Materias materias) {
		return "";
	}

}

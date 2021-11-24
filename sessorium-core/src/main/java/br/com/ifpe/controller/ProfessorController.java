package br.com.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Professor;

@Controller
public class ProfessorController {
	
	@GetMapping
	public String exibirFomrCadastroProfessor(){
		return "";
		
	}
	@PostMapping
	public String cadastrarProfessor(Professor professor) {
		return "";
	}

}

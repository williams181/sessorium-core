package br.com.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Turma;

@Controller
public class TurmaController {

	@GetMapping
	public String exibirFomrCadastroTurma(){
		return "";
		
	}
	@PostMapping
	public String cadastrarTurma(Turma turma) {
		return "";
	}
}

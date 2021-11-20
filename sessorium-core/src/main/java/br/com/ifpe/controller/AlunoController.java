package br.com.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Aluno;

@Controller
public class AlunoController {

	@GetMapping
	public String exibirFomrCadastroAluno(){
		return "";
		
	}
	@PostMapping
	public String cadastrarAluno(Aluno aluno) {
		return "";
	}
}

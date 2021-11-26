package br.com.ifpe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Turma;

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

package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Turma;
import br.ifpe.com.Service.TurmaService;

@Controller
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	private List<Turma> turmas = new ArrayList<>();
	
	@GetMapping("/exibirTurma")
	public String exibirPaginaTurma(Turma turma) {
		return "pagina-turma";
	}
	
	@GetMapping("/exibirFormTurma")
	public String exibirForm(Turma turma) {
		return "turma-form";
	}
	
	@PostMapping("/salvarTurma")
	public String salvarTurma(Turma turma) {
		this.turmas.remove(turma);
		this.turmas.add(turma);
		this.turmaService.inserirTurma(turma);
		System.out.println(turma);
		return "redirect:/exibirTurma";
	}
	
}

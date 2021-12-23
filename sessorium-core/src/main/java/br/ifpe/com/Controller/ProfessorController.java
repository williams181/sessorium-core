package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Professor;
import br.ifpe.com.Service.ProfessorService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	private List<Professor> professores = new ArrayList<>();

	@GetMapping("/exibirProfessor")
	public String exibirPaginaProfessor(Professor professor) {
		return "pagina-professor";
	}
	
	@GetMapping("/exibirFormProfessor")
	public String exibirForm(Professor professor) {
		return "professor-form";
	}

	@PostMapping("/salvarProfessor")
	public String salvarProfessor(Professor professor) {
		this.professores.remove(professor);
		this.professores.add(professor);
		this.professorService.inserirProfessor(professor);
		System.out.println(professor);
		return "redirect:/exibirProfessor";
	}
}

package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Aluno;
import br.ifpe.com.Service.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	private List<Aluno> alunos = new ArrayList<>();

	@GetMapping("/exibirAluno")
	public String exibirPaginaAluno(Aluno aluno) {
		return "pagina-aluno";
	}
	
	@GetMapping("/exibirFormAluno")
	public String exibirForm(Aluno aluno) {
		return "aluno-form";
	}

	@PostMapping("/salvarAluno")
	public String salvarAluno(Aluno aluno) {
		this.alunos.remove(aluno);
		this.alunos.add(aluno);
		this.alunoService.inserirAluno(aluno);
		System.out.println(aluno);
		return "redirect:/listarAlunos";
	}
	
	@GetMapping("/listarAlunos")
	public String listarAlunos(Model model) {
		model.addAttribute("lista", alunos);
		return "aluno-list";
	}
	
}

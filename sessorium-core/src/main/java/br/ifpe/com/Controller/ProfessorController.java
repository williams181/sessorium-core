package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Formacao;
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
	
	@ModelAttribute("enum_formacao")
	public Formacao[] getEnumFormacao() {
		return Formacao.values();
	}
	
	@GetMapping("/exibirAlterarProfessor")
	public String exibirAlterarProfessor(Professor professor,Integer codigo, Model model) {
		Professor cont = this.professorService.buscarProfessor(codigo);
		model.addAttribute("professor", cont);
		this.professorService.removerProfessor(codigo);
		this.professorService.inserirProfessor(professor);
		return "professor-alterar";
	}
	
	@GetMapping("/exibirFormProfessor")
	public String exibirForm(Professor professor) {
		return "professor-form";
	}
	
	@GetMapping("/excluirProfessor")
	public String excluirProfessor(Integer codigo) {
		this.professorService.removerProfessor(codigo);
		return "redirect:/listarProfessores";
	}

	@PostMapping("/salvarProfessor")
	public String salvarProfessor(Professor professor) {
		this.professores.remove(professor);
		this.professores.add(professor);
		this.professorService.inserirProfessor(professor);
		System.out.println(professor);
		return "redirect:/listarProfessores";
	}
	
	@GetMapping("/listarProfessores")
	public String listarProfessores(Model model) {
		model.addAttribute("listarProfessor", professores);
		return "professor-list";
	}
}

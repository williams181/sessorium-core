package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Enumerated.CategoriaPcd;
import br.ifpe.com.Model.Aluno;
import br.ifpe.com.Service.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	private List<Aluno> alunos = new ArrayList<>();

	@GetMapping("/exibirAluno")
	public String exibirPaginaAluno(Aluno aluno) {
		return "aluno/pagina-aluno";
	}

	@ModelAttribute("enum_categoriaPcd")
	public CategoriaPcd[] getEnumCategoriaPcd() {
		return CategoriaPcd.values();
	}

	@GetMapping("/exibirAlterarAluno")
	public String exibirAlterarAluno(Aluno aluno, Integer codigo, Model model) {
		Aluno cont = this.alunoService.buscarAluno(codigo);
		model.addAttribute("aluno", cont);
		this.alunos.remove(aluno);
		this.alunos.add(aluno);
		this.alunoService.removerAluno(codigo);
//		this.alunoService.inserirAluno(aluno);
		return "aluno/aluno-alterar";
	}

	@GetMapping("/exibirFormAluno")
	public String exibirForm(Aluno aluno) {
		return "aluno/aluno-form";
	}

	@GetMapping("/excluirAluno")
	public String excluirAluno(Aluno aluno, Integer codigo) {
		this.alunos.remove(aluno);
		this.alunoService.removerAluno(codigo);
		return "aluno/aluno-list";
	}

	@PostMapping("/salvarAluno")
	public String salvarAluno(Aluno aluno) {
		this.alunos.remove(aluno);
		this.alunos.add(aluno);
//		this.alunoService.inserirAluno(aluno);
		System.out.println(aluno);
		return "redirect:/listarAlunos";
	}

	@GetMapping("/listarAlunos")
	public String listarAlunos(Model model) {
		model.addAttribute("listarAluno", alunos);
		return "aluno/aluno-list";
	}

}

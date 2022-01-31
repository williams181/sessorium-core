package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Aula;
import br.ifpe.com.Service.AulaService;

@Controller
public class AulaController {
	
	@Autowired
	private AulaService aulaService;

	private List<Aula> aulas = new ArrayList<>();

	@GetMapping("/exibirAula")
	public String exibirAula(Aula aula) {
		return "aula/pagina-aula";
	}

	@GetMapping("/exibirAlterarAula")
	public String exibirAlterarAula(Aula aula, Integer codigo, Model model) {
		Aula cont = this.aulaService.buscarAula(codigo);
		model.addAttribute("aula", cont);
		this.aulaService.removerAula(codigo);
		this.aulaService.inserirAula(aula);
		return "aula/aula-alterar";
	}

	@GetMapping("/exibirFormAula")
	public String exibirFormAula(Aula aula) {
		return "aula/aula-form";
	}

	@GetMapping("/excluirAula")
	public String excluirAula(Aula aula, Integer codigo) {
		this.aulaService.removerAula(codigo);
		return "aula/aula-list";
	}

	@PostMapping("/salvarAula")
	public String salvarAula(Aula aula) {
		this.aulaService.inserirAula(aula);
		System.out.println(aula);
		return "redirect:/listarAulas";
	}

	@GetMapping("/listarAulas")
	public String listarAulas(Model model) {
		model.addAttribute("listarAula", aulas);
		return "aula/aula-list";
	}

}

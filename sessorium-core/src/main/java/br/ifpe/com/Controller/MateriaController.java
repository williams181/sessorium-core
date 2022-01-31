package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Materia;
import br.ifpe.com.Service.MateriaService;

@Controller
public class MateriaController {

	@Autowired
	private MateriaService materiaService;

	private List<Materia> materias = new ArrayList<>();

	@GetMapping("/exibirMateria")
	public String exibirMateria(Materia materia) {
		return "pagina-materia";
	}

	@GetMapping("/exibirAlterarMateria")
	public String exibirAlterarMateria(Materia materia, Integer codigo, Model model) {
		Materia cont = this.materiaService.buscarMateria(codigo);
		model.addAttribute("materia", cont);
		this.materiaService.removerMateria(codigo);
		this.materiaService.inserirMateria(materia);
		return "materia-alterar";
	}

	@GetMapping("/exibirFormMateria")
	public String exibirFormMateria(Materia materia) {
		return "materia-form";
	}

	@GetMapping("/excluirMateria")
	public String excluirMateria(Materia materia, Integer codigo) {
		this.materiaService.removerMateria(codigo);
		return "materia-list";
	}

	@PostMapping("/salvarMateria")
	public String salvarMateria(Materia materia) {
		this.materiaService.inserirMateria(materia);
		System.out.println(materia);
		return "redirect:/listarMaterias";
	}

	@GetMapping("/listarMaterias")
	public String listarMaterias(Model model) {
		model.addAttribute("listarMateria", materias);
		return "materia-list";
	}
}

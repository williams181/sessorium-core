package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String exibirPaginaMateria(Materia materia) {
		return "pagina-materia";
	}
	
	@GetMapping("/exibirFormMateria")
	public String exibirForm(Materia materia) {
		return "materia-form";
	}

	@PostMapping("/salvarMateria")
	public String salvarMateria(Materia materia) {
		this.materias.remove(materia);
		this.materias.add(materia);
		this.materiaService.inserirMateria(materia);
		System.out.println(materia);
		return "redirect:/exibirMateria";
	}
}

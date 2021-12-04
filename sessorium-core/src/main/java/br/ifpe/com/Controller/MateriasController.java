package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Materias;
import br.ifpe.com.Service.MateriasService;

	@Controller
	public class MateriasController {
	
	@Autowired 
	private MateriasService materiasService;
	
	private List<Materias> materias = new ArrayList<>();
	
	@GetMapping("/exibirMaterias")
	public String exibirForm(Materias materias) {
		return "materias-form";
	}
	
	@PostMapping("/salvarMaterias")
	public String salvarMaterias(Materias materias) {
		this.materias.remove(materias);
		this.materias.add(materias);
		this.materiasService.inserirMaterias(materias);
		System.out.println(materias);
		return "redirect:/listarMaterias";
	}
}

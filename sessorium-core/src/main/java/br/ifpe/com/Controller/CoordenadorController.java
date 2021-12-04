package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Coordenador;
import br.ifpe.com.Service.CoordenadorService;

@Controller
public class CoordenadorController {

	@Autowired
	private CoordenadorService coordenadorService;

	private List<Coordenador> coordenadores = new ArrayList<>();

	@GetMapping("/exibirCoordenador")
	public String exibirForm(Coordenador coordenador) {
		return "coordenador-form";
	}

	@PostMapping("/salvarCoordenador")
	public String salvarCoordenador(Coordenador coordenador) {
		this.coordenadores.remove(coordenador);
		this.coordenadores.add(coordenador);
		this.coordenadorService.inserirCoordenador(coordenador);
		System.out.println(coordenador);
		return "redirect:/listarCoordenador";
	}

}

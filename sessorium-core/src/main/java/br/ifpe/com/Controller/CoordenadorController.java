package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Enumerated.Formacao;
import br.ifpe.com.Model.Coordenador;
import br.ifpe.com.Service.CoordenadorService;

@Controller
public class CoordenadorController {

	@Autowired
	private CoordenadorService coordenadorService;

	private List<Coordenador> coordenadores = new ArrayList<>();
	
	@GetMapping("/")
	public String exibirIndex(Coordenador coordenador) {
		return "index";
	}

	@GetMapping("/exibirCoordenador")
	public String exibirCoordenador(Coordenador coordenador) {
		return "coordenador/pagina-coordenador";
	}
	
	@ModelAttribute("enum_formacao")
	public Formacao[] enum_formacao() {
		return Formacao.values();
	}
	
	@GetMapping("/exibirAlterarCoordenador")
	public String exibirAlterarCoordenador(Coordenador coordenador,Integer codigo, Model model) {
		Coordenador cont = this.coordenadorService.buscarCoordenador(codigo);
		model.addAttribute("coordenador", cont);
		this.coordenadores.remove(coordenador);
		this.coordenadores.add(coordenador)
;		this.coordenadorService.removerCoordenador(codigo);
		this.coordenadorService.inserirCoordenador(coordenador);
		return "coordenador/coordenador-alterar";
	}
	
	@GetMapping("/exibirFormCoordenador")
	public String exibirFormCoordenador(Coordenador coordenador) {
		return "coordenador/coordenador-form";
	}
	
	@GetMapping("/excluirCoordenador")
	public String excluirCoordenador(Coordenador coordenador, Integer codigo) {
		this.coordenadorService.removerCoordenador(codigo);
		return "coordenador/coordenador-list";
	}

	@PostMapping("/salvarCoordenador")
	public String salvarCoordenador(Coordenador coordenador) {
		this.coordenadorService.inserirCoordenador(coordenador);
		System.out.println(coordenador);
		return "redirect:/listarCoordenadores";
	}
	
	@GetMapping("/listarCoordenadores")
	public String listarCoordenadores(Model model) {
		model.addAttribute("listarCoordenador", coordenadores);
		return "coordenador/coordenador-list";
	}

}

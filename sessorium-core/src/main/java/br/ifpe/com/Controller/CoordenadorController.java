package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Coordenador;
import br.ifpe.com.Model.Formacao;
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
	public String exibirPaginaCoordenador(Coordenador coordenador) {
		return "pagina-coordenador";
	}
	
	@ModelAttribute("enum_formacao")
	public Formacao[] getEnumFormacao() {
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
		return "coordenador-alterar";
	}
	
	@GetMapping("/exibirFormCoordenador")
	public String exibirForm(Coordenador coordenador) {
		return "coordenador-form";
	}
	
	@GetMapping("/excluirCoordenador")
	public String excluirCoordenador(Coordenador coordenador, Integer codigo) {
		this.coordenadores.remove(coordenador);
		this.coordenadorService.removerCoordenador(codigo);
		return "coordenador-list";
	}

	@PostMapping("/salvarCoordenador")
	public String salvarCoordenador(Coordenador coordenador) {
		this.coordenadores.remove(coordenador);
		this.coordenadores.add(coordenador);
		this.coordenadorService.inserirCoordenador(coordenador);
		System.out.println(coordenador);
		return "redirect:/listarCoordenadores";
	}
	
	@GetMapping("/listarCoordenadores")
	public String listarCoordenadores(Model model) {
		model.addAttribute("listarCoordenador", coordenadores);
		return "coordenador-list";
	}

}

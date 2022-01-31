package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Entrega;
import br.ifpe.com.Service.EntregaService;

@Controller
public class EntregaController {

	@Autowired
	private EntregaService entregaService;

	private List<Entrega> entregas = new ArrayList<>();

	@GetMapping("/exibirEntrega")
	public String exibirEntrega(Entrega entrega) {
		return "entrega/pagina-entrega";
	}

	@GetMapping("/exibirAlterarEntrega")
	public String exibirAlterarEntrega(Entrega entrega,Integer codigo, Model model) {
		Entrega cont = this.entregaService.buscarEntrega(codigo);
		model.addAttribute("aluno", cont);
		this.entregaService.removerEntrega(codigo);
		this.entregaService.inserirEntrega(entrega);
		return "escola/escola-alterar";
	}
	
	@GetMapping("/exibirFormEntrega")
	public String exibirFormEntrega(Entrega entrega) {
		return "entrega/entrega-form";
	}
	
	@GetMapping("/excluirEntrega")
	public String excluirEntrega(Entrega entrega, Integer codigo) {
		this.entregaService.removerEntrega(codigo);
		return "entrega/entrega-list";
	}

	@PostMapping("/salvarEntrega")
	public String salvarEntrega(Entrega entrega) {
		this.entregaService.inserirEntrega(entrega);
		System.out.println(entrega);
		return "redirect:/listarEntregas";
	}
	
	@GetMapping("/listarEntregas")
	public String listarEntregas(Model model) {
		model.addAttribute("listarEntrega", entregas);
		return "entrega/entrega-list";
	}
}

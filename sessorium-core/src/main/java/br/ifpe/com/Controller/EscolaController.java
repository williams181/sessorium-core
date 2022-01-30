package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Escola;
import br.ifpe.com.Service.EscolaService;

@Controller
public class EscolaController {

	@Autowired
	private EscolaService escolaService;

	private List<Escola> escolas = new ArrayList<>();

	@GetMapping("/exibirEscola")
	public String exibirPaginaEscola(Escola escola) {
		return "escola/pagina-escola";
	}
	

	@GetMapping("/exibirAlterarEscola")
	public String exibirAlterarEscola(Escola escola,Integer codigo, Model model) {
		Escola cont = this.escolaService.buscarEscola(codigo);
		model.addAttribute("aluno", cont);
		this.escolas.remove(escola);
		this.escolas.add(escola);
		this.escolaService.removerEscola(codigo);
		this.escolaService.inserirEscola(escola);
		return "escola/escola-alterar";
	}
	
	@GetMapping("/exibirFormEscola")
	public String exibirForm(Escola escola) {
		return "escola/escola-form";
	}
	
	@GetMapping("/excluirEscola")
	public String excluirEscola(Escola escola, Integer codigo) {
		this.escolas.remove(escola);
		this.escolaService.removerEscola(codigo);
		return "escola/escola-list";
	}

	@PostMapping("/salvarEscola")
	public String salvarEscola(Escola escola) {
		this.escolas.remove(escola);
		this.escolas.add(escola);
		this.escolaService.inserirEscola(escola);
		System.out.println(escola);
		return "redirect:/listarEscolas";
	}
	
	@GetMapping("/listarEscolas")
	public String listarEscolas(Model model) {
		model.addAttribute("listarEscola", escolas);
		return "escola/escola-list";
	}
}

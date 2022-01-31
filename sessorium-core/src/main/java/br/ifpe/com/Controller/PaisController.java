package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Pais;
import br.ifpe.com.Service.PaisService;
@Controller
public class PaisController {

	@Autowired
	private PaisService paisService;

	private List<Pais> pais = new ArrayList<>();

	@GetMapping("/exibirPais")
	public String exibirPais(Pais pais) {
		return "pagina-pais";
	}

	@GetMapping("/exibirAlterarPais")
	public String exibirAlterarPais(Pais pais, Integer codigo, Model model) {
		Pais cont = this.paisService.buscarPais(codigo);
		model.addAttribute("pais", cont);
		this.paisService.removerPais(codigo);
		this.paisService.inserirPais(pais);
		return "pais-alterar";
	}

	@GetMapping("/exibirFormPais")
	public String exibirFormPais(Pais pais) {
		return "pais-form";
	}

	@GetMapping("/excluirPais")
	public String excluirPais(Pais pais, Integer codigo) {
		this.paisService.removerPais(codigo);
		return "aluno-list";
	}

	@PostMapping("/salvarPais")
	public String salvarPais(Pais pais) {
		this.paisService.inserirPais(pais);
		System.out.println(pais);
		return "redirect:/listarPais";
	}

	@GetMapping("/listarPais")
	public String listarPais(Model model) {
		model.addAttribute("listarPais", pais);
		return "pais-list";
	}
}

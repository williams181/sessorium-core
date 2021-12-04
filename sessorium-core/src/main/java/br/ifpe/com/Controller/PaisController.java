package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String exibirForm(Pais pais) {
		return "pais-form";
	}

	@PostMapping("/salvarPais")
	public String salvarPais(Pais pais) {
		this.pais.remove(pais);
		this.pais.add(pais);
		this.paisService.inseirPais(pais);
		System.out.println(pais);
		return "redirect:/listarPais";
	}

}

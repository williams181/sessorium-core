package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Boletim;
import br.ifpe.com.Service.BoletimService;

@Controller
public class BoletimController {
	
	@Autowired
	private BoletimService boletimService;

	private List<Boletim> boletims = new ArrayList<>();

	@GetMapping("/exibirBoletim")
	public String exibirBoletim(Boletim boletim) {
		return "boletim/boletim-aula";
	}

	@GetMapping("/exibirAlterarBoletim")
	public String exibirAlterarBoletim(Boletim boletim, Integer codigo, Model model) {
		Boletim cont = this.boletimService.buscarBoletim(codigo);
		model.addAttribute("boletim", cont);
		this.boletimService.removerBoletim(codigo);
		this.boletimService.inserirBoletim(boletim);
		return "boletim/boletim-alterar";
	}

	@GetMapping("/exibirFormBoletim")
	public String exibirFormBoletim(Boletim boletim) {
		return "boletim/boletim-form";
	}

	@GetMapping("/excluirBoletim")
	public String excluirBoletim(Boletim boletim, Integer codigo) {
		this.boletimService.removerBoletim(codigo);
		return "boletim/boletim-list";
	}

	@PostMapping("/salvarBoletim")
	public String salvarBoletim(Boletim boletim) {
		this.boletimService.inserirBoletim(boletim);
		System.out.println(boletim);
		return "redirect:/listarBoletims";
	}

	@GetMapping("/listarBoletims")
	public String listarBoletims(Model model) {
		model.addAttribute("listarBoletim", boletims);
		return "boletim/boletim-list";
	}

}

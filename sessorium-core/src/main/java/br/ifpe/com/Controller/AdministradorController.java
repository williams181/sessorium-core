package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Administrador;
import br.ifpe.com.Service.AdministradorService;

@Controller
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;

	private List<Administrador> administradores = new ArrayList<>();

	@GetMapping("/exibirAdministrador")
	public String exibirPaginaAdministrador(Administrador administrador) {
		return "pagina-Administrador";
	}

	@GetMapping("/exibirAlterarAdministrador")
	public String exibirAlterarAdministrador(Administrador administrador, Integer codigo, Model model) {
		Administrador cont = this.administradorService.buscarAdministrador(codigo);
		model.addAttribute("administrador", cont);
		this.administradores.remove(administrador);
		this.administradores.add(administrador);
		this.administradorService.removerAdministrador(codigo);
		this.administradorService.inserirAdministrador(administrador);
		return "administrador-alterar";
	}

	@GetMapping("/exibirFormAdministrador")
	public String exibirForm(Administrador administrador) {
		return "administrador-form";
	}

	@GetMapping("/excluirAdministrador")
	public String excluirAdministrador(Administrador administrador, Integer codigo) {
		this.administradores.remove(administrador);
		this.administradorService.removerAdministrador(codigo);
		return "administrador-list";
	}

	@PostMapping("/salvarAdministrador")
	public String salvarAdministrador(Administrador administrador) {
		this.administradores.remove(administrador);
		this.administradores.add(administrador);
		this.administradorService.inserirAdministrador(administrador);
		System.out.println(administrador);
		return "redirect:/listarAdministradores";
	}

	@GetMapping("/listarAdministradores")
	public String listarAdministrador(Model model) {
		model.addAttribute("listarAdministrador", administradores);
		return "administrador-list";
	}
}

package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String exibirForm(Administrador administrador) {
		return "administrador-form";
	}

	@PostMapping("/salvarAdministrador")
	public String salvarAdministrador(Administrador administrador) {
		this.administradores.remove(administrador);
		this.administradores.add(administrador);
		this.administradorService.inserirAdministrador(administrador);
		System.out.println(administrador);
		return "redirect:/listarAdministrador";
	}

}

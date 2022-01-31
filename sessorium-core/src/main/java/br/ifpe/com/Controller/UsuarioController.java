package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Usuario;
import br.ifpe.com.Service.UsuarioService;
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	private List<Usuario> usuarios = new ArrayList<>();

	@GetMapping("/exibirUsuario")
	public String exibirUsuario(Usuario usuario) {
		return "usuario-aluno";
	}

	@GetMapping("/exibirAlterarUsuario")
	public String exibirAlterarUsuario(Usuario usuario, Integer codigo, Model model) {
		Usuario cont = this.usuarioService.buscarUsuario(codigo);
		model.addAttribute("usuario", cont);
		this.usuarioService.removerUsuario(codigo);
		this.usuarioService.inserirUsuario(usuario);
		return "usuario-alterar";
	}

	@GetMapping("/exibirFormUsuario")
	public String exibirFormUsuario(Usuario usuario) {
		return "usuario-form";
	}

	@GetMapping("/excluirUsuario")
	public String excluirUsuario(Usuario usuario, Integer codigo) {
		this.usuarioService.removerUsuario(codigo);
		return "usuario-list";
	}

	@PostMapping("/salvarUsuario")
	public String salvarUsuario(Usuario usuario) {
		this.usuarioService.inserirUsuario(usuario);
		System.out.println(usuario);
		return "redirect:/listarUsuarios";
	}

	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model model) {
		model.addAttribute("listarUsuario", usuarios);
		return "usuario-list";
	}

}

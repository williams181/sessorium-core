package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Comentario;
import br.ifpe.com.Service.ComentarioService;

@Controller
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;

	private List<Comentario> comentarios = new ArrayList<>();

	@GetMapping("/exibirComentario")
	public String exibirPaginaComentario(Comentario comentario) {
		return "pagina-comentario";
	}

	@GetMapping("/exibirAlterarComentario")
	public String exibirAlterarComentario(Comentario comentario, Integer codigo, Model model) {
		Comentario cont = this.comentarioService.buscarComentario(codigo);
		model.addAttribute("comentario", cont);
		this.comentarios.remove(comentario);
		this.comentarios.add(comentario);
		this.comentarioService.removerComentario(codigo);
		this.comentarioService.inserirComentario(comentario);
		return "comentario-alterar";
	}

	@GetMapping("/exibirFormComentario")
	public String exibirForm(Comentario comentario) {
		return "comentario-form";
	}

	@GetMapping("/excluirComentario")
	public String excluirComentario(Comentario comentario, Integer codigo) {
		this.comentarios.remove(comentario);
		this.comentarioService.removerComentario(codigo);
		return "comentario-list";
	}

	@PostMapping("/salvarComentario")
	public String salvarComentario(Comentario comentario) {
		this.comentarios.remove(comentario);
		this.comentarios.add(comentario);
		this.comentarioService.inserirComentario(comentario);
		System.out.println(comentario);
		return "redirect:/listarComentarios";
	}

	@GetMapping("/listarComentarios")
	public String listarComentarios(Model model) {
		model.addAttribute("listarComentario", comentarios);
		return "comentario-list";
	}
	
}

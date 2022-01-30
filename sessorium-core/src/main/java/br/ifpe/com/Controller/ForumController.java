package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Forum;
import br.ifpe.com.Service.ForumService;
@Controller
public class ForumController {

	@Autowired
	private ForumService forumService;

	private List<Forum> forums = new ArrayList<>();

	@GetMapping("/exibirForum")
	public String exibirPaginaForum(Forum forum) {
		return "pagina-forum";
	}

	@GetMapping("/exibirAlterarForum")
	public String exibirAlterarForum(Forum forum, Integer codigo, Model model) {
		Forum cont = this.forumService.buscarForum(codigo);
		model.addAttribute("pais", cont);
		this.forums.remove(forum);
		this.forums.add(forum);
		this.forumService.removerForum(codigo);
		this.forumService.inserirForum(forum);
		return "forum-alterar";
	}

	@GetMapping("/exibirFormForum")
	public String exibirForum(Forum forum) {
		return "forum-form";
	}

	@GetMapping("/excluirForum")
	public String excluirForum(Forum forum, Integer codigo) {
		this.forums.remove(forum);
		this.forumService.removerForum(codigo);
		return "forum-list";
	}

	@PostMapping("/salvarForum")
	public String salvarPais(Forum forum) {
		this.forums.remove(forum);
		this.forums.add(forum);
		this.forumService.inserirForum(forum);
		System.out.println(forum);
		return "redirect:/listarForums";
	}

	@GetMapping("/listarForum")
	public String listarForum(Model model) {
		model.addAttribute("listarForum", forums);
		return "forum-list";
	}
}

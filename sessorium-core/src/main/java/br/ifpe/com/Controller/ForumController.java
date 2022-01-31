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
	public String exibirForum(Forum forum) {
		return "pagina-forum";
	}

	@GetMapping("/exibirAlterarForum")
	public String exibirAlterarForum(Forum forum, Integer codigo, Model model) {
		Forum cont = this.forumService.buscarForum(codigo);
		model.addAttribute("pais", cont);
		this.forumService.removerForum(codigo);
		this.forumService.inserirForum(forum);
		return "forum-alterar";
	}

	@GetMapping("/exibirFormForum")
	public String exibirFormForum(Forum forum) {
		return "forum-form";
	}

	@GetMapping("/excluirForum")
	public String excluirForum(Forum forum, Integer codigo) {
		this.forumService.removerForum(codigo);
		return "forum-list";
	}

	@PostMapping("/salvarForum")
	public String salvarForum(Forum forum) {
		this.forumService.inserirForum(forum);
		System.out.println(forum);
		return "redirect:/listarForums";
	}

	@GetMapping("/listarForums")
	public String listarForums(Model model) {
		model.addAttribute("listarForum", forums);
		return "forum-list";
	}
}

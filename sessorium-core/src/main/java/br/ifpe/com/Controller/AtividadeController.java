package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Atividade;
import br.ifpe.com.Service.AtividadeService;

@Controller
public class AtividadeController {
	
	@Autowired
	private AtividadeService atividadeService;

	private List<Atividade> atividades = new ArrayList<>();

	@GetMapping("/exibirAtividade")
	public String exibirPaginaAtividade(Atividade atividade) {
		return "atividade/pagina-atividade";
	}

	@GetMapping("/exibirAlterarAtividade")
	public String exibirAlterarAtividade(Atividade atividade, Integer codigo, Model model) {
		Atividade cont = this.atividadeService.buscarAtividade(codigo);
		model.addAttribute("atividade", cont);
		this.atividades.remove(atividade);
		this.atividades.add(atividade);
		this.atividadeService.removerAtividade(codigo);
		this.atividadeService.inserirAtividade(atividade);
		return "atividade/atividade-alterar";
	}

	@GetMapping("/exibirFormAtividade")
	public String exibirForm(Atividade atividade) {
		return "atividade/atividade-form";
	}

	@GetMapping("/excluirAtividade")
	public String excluirAluno(Atividade atividade, Integer codigo) {
		this.atividades.remove(atividade);
		this.atividadeService.removerAtividade(codigo);
		return "atividade/atividade-list";
	}

	@PostMapping("/salvarAtividade")
	public String salvarAtividade(Atividade atividade) {
		this.atividades.remove(atividade);
		this.atividades.add(atividade);
		this.atividadeService.inserirAtividade(atividade);
		System.out.println(atividade);
		return "redirect:/listarAtividades";
	}

	@GetMapping("/listarAtividades")
	public String listarAtividades(Model model) {
		model.addAttribute("listarAtividade", atividades);
		return "atividade/atividade-list";
	}

}

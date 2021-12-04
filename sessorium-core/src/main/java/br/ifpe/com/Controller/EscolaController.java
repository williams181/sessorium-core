package br.ifpe.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.com.Model.Escola;
import br.ifpe.com.Service.EscolaService;

	@Controller
	public class EscolaController {
		
		@Autowired
		private EscolaService escolaService;
		
		private List<Escola> escolas = new ArrayList<>();

		@GetMapping("/exibirEscola")
		public String exibirForm(Escola escola){
			return "escolas-form";
			
		}
		
		@PostMapping("/salvarEscola")
		public String salvarEscola(Escola escola) {
			this.escolas.remove(escola);
			this.escolas.add(escola);
			this.escolaService.inserirEscola(escola);
			System.out.println(escola);
			return "redirect:/listarEscola";
		}
}

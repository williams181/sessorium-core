package br.ifpe.com.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.com.Service.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResourse {

	@Autowired
	private AlunoService alunoService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<AlunoDTO>> findAll() {
//		List<Aluno> list = alunoService.findAll();
//		List<AlunoDTO> listDto = list.stream().map(AlunoDTO::new).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDto);
//	}
	
}

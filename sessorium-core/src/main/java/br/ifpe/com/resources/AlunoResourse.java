package br.ifpe.com.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.com.Dto.AlunoDTO;
import br.ifpe.com.Model.Aluno;
import br.ifpe.com.Service.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResourse {

	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<Aluno> list = alunoService.findAll();
		List<AlunoDTO> listDto = list.stream().map(AlunoDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno retorno;
		retorno = alunoService.buscarAluno(id);
		return ResponseEntity.ok().body(retorno);
	}
	
}

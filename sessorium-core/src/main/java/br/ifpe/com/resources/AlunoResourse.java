package br.ifpe.com.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ifpe.com.Dto.AlunoDto;
import br.ifpe.com.Model.Aluno;
import br.ifpe.com.Repository.AlunoRepository;
import br.ifpe.com.Service.AlunoService;

@RestController
@RequestMapping(value = "/sessorium")
public class AlunoResourse {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private AlunoService alunoService;

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public List<Aluno> Get() {
		return alunoRepository.findAll();
	}

	@RequestMapping(value = "/aluno/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Aluno> aluno = alunoRepository.findById(codigo);
		if (aluno.isPresent())
			return new ResponseEntity<Aluno>(aluno.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Void> insert(@Valid @RequestBody AlunoDto objDto) {
//		Aluno obj = alunoService.fromDTO(objDto);
//		obj = alunoService.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
//	public Aluno Post(@Valid @RequestBody Aluno aluno) {
//		return alunoRepository.save(aluno);
//	}

	@RequestMapping(value = "/aluno/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Aluno> Put(@PathVariable(value = "codigo") int codigo, @Valid @RequestBody Aluno newAluno) {
		Optional<Aluno> oldAluno = alunoRepository.findById(codigo);
		if (oldAluno.isPresent()) {
			Aluno aluno = oldAluno.get();
			aluno.setNome(newAluno.getNome());
			alunoRepository.save(aluno);
			return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/aluno/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Aluno> aluno = alunoRepository.findById(codigo);
		if (aluno.isPresent()) {
			alunoRepository.delete(aluno.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

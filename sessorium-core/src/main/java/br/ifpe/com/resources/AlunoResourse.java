package br.ifpe.com.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.com.Model.Aluno;
import br.ifpe.com.Repository.AlunoRepository;
import br.ifpe.com.Service.AlunoService;

//@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping(value = "/sessorium")
public class AlunoResourse {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AlunoRepository alunoRepository;

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public List<Aluno> Get() {
		return alunoRepository.findAll();
	}

	@RequestMapping(value = "/alunoId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Aluno> aluno = alunoRepository.findById(codigo);
		if (aluno.isPresent())
			return new ResponseEntity<Aluno>(aluno.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/alunoEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> GetByEmail(@PathVariable(value = "email") String email) {
		Optional<Aluno> aluno = alunoRepository.findByEmail(email);
		if (aluno.isPresent())
			return new ResponseEntity<Aluno>(aluno.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// foram retiradas as anotações @RequestBody logo apos o @valid
	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	public Aluno Post(@Valid Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@RequestMapping(value = "/aluno/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Aluno> Put(@PathVariable(value = "codigo") int codigo, @Valid Aluno newAluno) {
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

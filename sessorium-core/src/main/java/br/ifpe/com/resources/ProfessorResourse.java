package br.ifpe.com.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.com.Model.Professor;
import br.ifpe.com.Repository.ProfessorRepository;
import br.ifpe.com.Service.ProfessorService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class ProfessorResourse {
	
	@Autowired
	private ProfessorService professorService;

	@Autowired
	private ProfessorRepository professorRepository;

	@RequestMapping(value = "/professores", method = RequestMethod.GET)
	public List<Professor> Get() {
		return professorRepository.findAll();
	}

	@RequestMapping(value = "/professorId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Professor> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Professor> professor = professorRepository.findById(codigo);
		if (professor.isPresent())
			return new ResponseEntity<Professor>(professor.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/professorEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<Professor> GetByEmail(@PathVariable(value = "email") String email) {
		Optional<Professor> professor = professorRepository.findByEmail(email);
		if (professor.isPresent())
			return new ResponseEntity<Professor>(professor.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	//@Valid @RequestBody
	@RequestMapping(value = "/professor", method = RequestMethod.POST)
	public Professor Post( Professor professor) {
		return professorRepository.save(professor);
	}

	@RequestMapping(value = "/professor/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Professor> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Professor newProfessor) {
		Optional<Professor> oldProfessor = professorRepository.findById(codigo);
		if (oldProfessor.isPresent()) {
			Professor professor = oldProfessor.get();
			professor.setNome(newProfessor.getNome());
			professorRepository.save(professor);
			return new ResponseEntity<Professor>(professor, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/professor/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Professor> professor = professorRepository.findById(codigo);
		if (professor.isPresent()) {
			professorRepository.delete(professor.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

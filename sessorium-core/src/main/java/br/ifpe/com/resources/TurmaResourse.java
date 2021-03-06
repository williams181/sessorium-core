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

import br.ifpe.com.Model.Turma;
import br.ifpe.com.Repository.TurmaRepository;
import br.ifpe.com.Service.TurmaService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class TurmaResourse {
	
	@Autowired
	private TurmaService turmaService;

	@Autowired
	private TurmaRepository turmaRepository;

	@RequestMapping(value = "/turmas", method = RequestMethod.GET)
	public List<Turma> Get() {
		return turmaRepository.findAll();
	}

	@RequestMapping(value = "/turmaId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Turma> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Turma> turma = turmaRepository.findById(codigo);
		if (turma.isPresent())
			return new ResponseEntity<Turma>(turma.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/turmaTitulo/{titulo}", method = RequestMethod.GET)
	public ResponseEntity<Turma> GetByTitulo(@PathVariable(value = "titulo") String titulo) {
		Optional<Turma> turma = turmaRepository.findByTitulo(titulo);
		if (turma.isPresent())
			return new ResponseEntity<Turma>(turma.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	//@Valid @RequestBody
	@RequestMapping(value = "/turma", method = RequestMethod.POST)
	public Turma Post(Turma turma) {
		return turmaRepository.save(turma);
	}

	@RequestMapping(value = "/turma/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Turma> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Turma newTurma) {
		Optional<Turma> oldTurma = turmaRepository.findById(codigo);
		if (oldTurma.isPresent()) {
			Turma turma = oldTurma.get();
			turma.setTitulo(newTurma.getTitulo());
			turmaRepository.save(turma);
			return new ResponseEntity<Turma>(turma, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/turma/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Turma> turma = turmaRepository.findById(codigo);
		if (turma.isPresent()) {
			turmaRepository.delete(turma.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

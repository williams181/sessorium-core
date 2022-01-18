package br.ifpe.com.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.com.Model.Aula;
import br.ifpe.com.Repository.AulaRepository;

@RestController
@RequestMapping(value = "/sessorium")
public class AulaResource {

	@Autowired
	private AulaRepository aulaRepository;

	@RequestMapping(value = "/aula", method = RequestMethod.GET)
	public List<Aula> Get() {
		return aulaRepository.findAll();
	}

	@RequestMapping(value = "/aula/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Aula> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Aula> aula = aulaRepository.findById(codigo);
		if (aula.isPresent())
			return new ResponseEntity<Aula>(aula.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/aula", method = RequestMethod.POST)
	public Aula Post(@Valid @RequestBody Aula aula) {
		return aulaRepository.save(aula);
	}

	@RequestMapping(value = "/aula/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Aula> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Aula newAula) {
		Optional<Aula> oldAula = aulaRepository.findById(codigo);
		if (oldAula.isPresent()) {
			Aula aula = oldAula.get();
			aula.setTitulo(newAula.getTitulo());
			aulaRepository.save(aula);
			return new ResponseEntity<Aula>(aula, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/aula/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Aula> aula = aulaRepository.findById(codigo);
		if (aula.isPresent()) {
			aulaRepository.delete(aula.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

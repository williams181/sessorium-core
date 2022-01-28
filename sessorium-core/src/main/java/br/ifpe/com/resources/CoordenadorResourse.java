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

import br.ifpe.com.Model.Coordenador;
import br.ifpe.com.Repository.CoordenadorRepository;
import br.ifpe.com.Service.CoordenadorService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class CoordenadorResourse {
	
	@Autowired
	private CoordenadorService coordenadorService;

	@Autowired
	private CoordenadorRepository coordenadorRepository;

	@RequestMapping(value = "/coordenadores", method = RequestMethod.GET)
	public List<Coordenador> Get() {
		return coordenadorRepository.findAll();
	}

	@RequestMapping(value = "/coordenadorId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Coordenador> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Coordenador> coordenador = coordenadorRepository.findById(codigo);
		if (coordenador.isPresent())
			return new ResponseEntity<Coordenador>(coordenador.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/coordenadorEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<Coordenador> GetByEmail(@PathVariable(value = "email") String email) {
		Optional<Coordenador> coordenador = coordenadorRepository.findByEmail(email);
		if (coordenador.isPresent())
			return new ResponseEntity<Coordenador>(coordenador.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/coordenador", method = RequestMethod.POST)
	public Coordenador Post(@Valid Coordenador coordenador) {
		return coordenadorRepository.save(coordenador);
	}

	@RequestMapping(value = "/coordenador/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Coordenador> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Coordenador newCoordenador) {
		Optional<Coordenador> oldCoordenador = coordenadorRepository.findById(codigo);
		if (oldCoordenador.isPresent()) {
			Coordenador coordenador = oldCoordenador.get();
			coordenador.setNome(newCoordenador.getNome());
			coordenadorRepository.save(coordenador);
			return new ResponseEntity<Coordenador>(coordenador, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/coordenador/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Coordenador> coordenador = coordenadorRepository.findById(codigo);
		if (coordenador.isPresent()) {
			coordenadorRepository.delete(coordenador.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

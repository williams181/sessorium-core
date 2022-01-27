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

import br.ifpe.com.Model.Pais;
import br.ifpe.com.Repository.PaisRepository;
import br.ifpe.com.Service.PaisService;

//@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping(value = "/sessorium")
public class PaisResourse {
	
	@Autowired
	private PaisService paisService;

	@Autowired
	private PaisRepository paisRepository;

	@RequestMapping(value = "/pais", method = RequestMethod.GET)
	public List<Pais> Get() {
		return paisRepository.findAll();
	}

	@RequestMapping(value = "/paisId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Pais> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Pais> pais = paisRepository.findById(codigo);
		if (pais.isPresent())
			return new ResponseEntity<Pais>(pais.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/paisEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<Pais> GetByEmail(@PathVariable(value = "email") String email) {
		Optional<Pais> pais = paisRepository.findByEmail(email);
		if (pais.isPresent())
			return new ResponseEntity<Pais>(pais.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pais", method = RequestMethod.POST)
	public Pais Post(@Valid Pais pais) {
		return paisRepository.save(pais);
	}

	@RequestMapping(value = "/pais/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Pais> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Pais newPais) {
		Optional<Pais> oldPais = paisRepository.findById(codigo);
		if (oldPais.isPresent()) {
			Pais pais = oldPais.get();
			pais.setNome(newPais.getNome());
			paisRepository.save(pais);
			return new ResponseEntity<Pais>(pais, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pais/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Pais> pais = paisRepository.findById(codigo);
		if (pais.isPresent()) {
			paisRepository.delete(pais.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

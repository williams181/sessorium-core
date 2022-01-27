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

import br.ifpe.com.Model.Boletim;
import br.ifpe.com.Repository.BoletimRepository;
import br.ifpe.com.Service.BoletimService;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping(value = "/sessorium")
public class BoletimResourse {
	
	@Autowired
	private BoletimService boletimSerivce;

	@Autowired
	private BoletimRepository boletimRepository;

	@RequestMapping(value = "/boletims", method = RequestMethod.GET)
	public List<Boletim> Get() {
		return boletimRepository.findAll();
	}

	@RequestMapping(value = "/boletim/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Boletim> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Boletim> boletim = boletimRepository.findById(codigo);
		if (boletim.isPresent())
			return new ResponseEntity<Boletim>(boletim.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/boletim/{titulo}", method = RequestMethod.GET)
	public ResponseEntity<Boletim> GetByTitulo(@PathVariable(value = "titulo") String titulo) {
		Optional<Boletim> boletim = boletimRepository.findByTitulo(titulo);
		if (boletim.isPresent())
			return new ResponseEntity<Boletim>(boletim.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/boletim", method = RequestMethod.POST)
	public Boletim Post(@Valid Boletim boletim) {
		return boletimRepository.save(boletim);
	}

	@RequestMapping(value = "/boletim/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Boletim> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Boletim newBoletim) {
		Optional<Boletim> oldBoletim = boletimRepository.findById(codigo);
		if (oldBoletim.isPresent()) {
			Boletim boletim = oldBoletim.get();
			boletim.setTitulo(newBoletim.getTitulo());
			boletimRepository.save(boletim);
			return new ResponseEntity<Boletim>(boletim, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/boletim/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Boletim> boletim = boletimRepository.findById(codigo);
		if (boletim.isPresent()) {
			boletimRepository.delete(boletim.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

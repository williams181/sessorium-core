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

import br.ifpe.com.Model.Entrega;
import br.ifpe.com.Repository.EntregaRepository;
import br.ifpe.com.Service.EntregaService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class EntregaResourse {
	
	@Autowired
	private EntregaService entregaService;

	@Autowired
	private EntregaRepository entregaRepository;

	@RequestMapping(value = "/entregas", method = RequestMethod.GET)
	public List<Entrega> Get() {
		return entregaRepository.findAll();
	}

	@RequestMapping(value = "/entregaId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Entrega> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Entrega> entrega = entregaRepository.findById(codigo);
		if (entrega.isPresent())
			return new ResponseEntity<Entrega>(entrega.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/entregaTitulo/{titulo}", method = RequestMethod.GET)
	public ResponseEntity<Entrega> GetByTitulo(@PathVariable(value = "titulo") String titulo) {
		Optional<Entrega> entrega = entregaRepository.findByTitulo(titulo);
		if (entrega.isPresent())
			return new ResponseEntity<Entrega>(entrega.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	//@Valid @RequestBody 
	@RequestMapping(value = "/entrega", method = RequestMethod.POST)
	public Entrega Post(Entrega entrega) {
		return entregaRepository.save(entrega);
	}

	@RequestMapping(value = "/entrega/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Entrega> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Entrega newEntrega) {
		Optional<Entrega> oldEntrega = entregaRepository.findById(codigo);
		if (oldEntrega.isPresent()) {
			Entrega entrega = oldEntrega.get();
			entrega.setTitulo(newEntrega.getTitulo());
			entregaRepository.save(entrega);
			return new ResponseEntity<Entrega>(entrega, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/entrega/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Entrega> entrega = entregaRepository.findById(codigo);
		if (entrega.isPresent()) {
			entregaRepository.delete(entrega.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

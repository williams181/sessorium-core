package br.ifpe.com.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.com.Model.Comentario;
import br.ifpe.com.Repository.ComentarioRepository;
import br.ifpe.com.Service.ComentarioService;

@CrossOrigin(origins = {"http://localhost:19006"})	
@RestController
@RequestMapping(value = "/sessorium")
public class ComentarioResourse {
	
	@Autowired
	private ComentarioService comentarioService;

	@Autowired
	private ComentarioRepository comentarioRepository;

	@RequestMapping(value = "/comentarios", method = RequestMethod.GET)
	public List<Comentario> Get() {
		return comentarioRepository.findAll();
	}

	@RequestMapping(value = "/comentarioId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Comentario> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Comentario> comentario = comentarioRepository.findById(codigo);
		if (comentario.isPresent())
			return new ResponseEntity<Comentario>(comentario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/comentarioTitulo/{titulo}", method = RequestMethod.GET)
	public ResponseEntity<Comentario> GetByTitulo(@PathVariable(value = "titulo") String titulo) {
		Optional<Comentario> comentario = comentarioRepository.findByTitulo(titulo);
		if (comentario.isPresent())
			return new ResponseEntity<Comentario>(comentario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	//@Valid @RequestBody 
	@RequestMapping(value = "/comentario", method = RequestMethod.POST)
	public Comentario Post(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

	@RequestMapping(value = "/comentario/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Comentario> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Comentario newComentario) {
		Optional<Comentario> oldComentario = comentarioRepository.findById(codigo);
		if (oldComentario.isPresent()) {
			Comentario comentario = oldComentario.get();
			comentario.setTitulo(newComentario.getTitulo());
			comentarioRepository.save(comentario);
			return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/comentario/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Comentario> comentario = comentarioRepository.findById(codigo);
		if (comentario.isPresent()) {
			comentarioRepository.delete(comentario.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

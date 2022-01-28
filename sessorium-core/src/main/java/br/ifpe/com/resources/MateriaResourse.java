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

import br.ifpe.com.Model.Materia;
import br.ifpe.com.Repository.MateriaRepository;
import br.ifpe.com.Service.MateriaService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class MateriaResourse {
	
	@Autowired
	private MateriaService materiaService;

	@Autowired
	private MateriaRepository materiaRepository;

	@RequestMapping(value = "/materias", method = RequestMethod.GET)
	public List<Materia> Get() {
		return materiaRepository.findAll();
	}

	@RequestMapping(value = "/materiaId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Materia> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Materia> materia = materiaRepository.findById(codigo);
		if (materia.isPresent())
			return new ResponseEntity<Materia>(materia.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/materiaTitulo/{titulo}", method = RequestMethod.GET)
	public ResponseEntity<Materia> GetByTitulo(@PathVariable(value = "titulo") String titulo) {
		Optional<Materia> materia = materiaRepository.findByTitulo(titulo);
		if (materia.isPresent())
			return new ResponseEntity<Materia>(materia.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/materia", method = RequestMethod.POST)
	public Materia Post(@Valid Materia materia) {
		return materiaRepository.save(materia);
	}

	@RequestMapping(value = "/materia/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Materia> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Materia newMateria) {
		Optional<Materia> oldMateria = materiaRepository.findById(codigo);
		if (oldMateria.isPresent()) {
			Materia materia = oldMateria.get();
			materia.setTitulo(newMateria.getTitulo());
			materiaRepository.save(materia);
			return new ResponseEntity<Materia>(materia, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/materia/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Materia> materia = materiaRepository.findById(codigo);
		if (materia.isPresent()) {
			materiaRepository.delete(materia.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

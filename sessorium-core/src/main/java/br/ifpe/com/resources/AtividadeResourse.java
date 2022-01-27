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

import br.ifpe.com.Model.Atividade;
import br.ifpe.com.Repository.AtividadeRepository;
import br.ifpe.com.Service.AtividadeService;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping(value = "/sessorium")
public class AtividadeResourse {
	
	@Autowired
	private AtividadeService atividadeService;

	@Autowired
	private AtividadeRepository atividadeRepository;

	@RequestMapping(value = "/atividades", method = RequestMethod.GET)
	public List<Atividade> Get() {
		return atividadeRepository.findAll();
	}

	@RequestMapping(value = "/atividade/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Atividade> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Atividade> atividade = atividadeRepository.findById(codigo);
		if (atividade.isPresent())
			return new ResponseEntity<Atividade>(atividade.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/atividade/{titulo}", method = RequestMethod.GET)
	public ResponseEntity<Atividade> GetByTitulo(@PathVariable(value = "titulo") String titulo) {
		Optional<Atividade> atividade = atividadeRepository.findByTitulo(titulo);
		if (atividade.isPresent())
			return new ResponseEntity<Atividade>(atividade.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/atividade", method = RequestMethod.POST)
	public Atividade Post(@Valid Atividade atividade) {
		return atividadeRepository.save(atividade);
	}

	@RequestMapping(value = "/atividade/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Atividade> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Atividade newAtividade) {
		Optional<Atividade> oldAtividade = atividadeRepository.findById(codigo);
		if (oldAtividade.isPresent()) {
			Atividade atividade = oldAtividade.get();
			atividade.setTitulo(newAtividade.getTitulo());
			atividadeRepository.save(atividade);
			return new ResponseEntity<Atividade>(atividade, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/atividade/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Atividade> atividade = atividadeRepository.findById(codigo);
		if (atividade.isPresent()) {
			atividadeRepository.delete(atividade.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

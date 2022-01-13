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

import br.ifpe.com.Model.Escola;
import br.ifpe.com.Repository.EscolaRepository;

@RestController
@RequestMapping(value = "/sessorium")
public class EscolaResourse {
	
	@Autowired
	private EscolaRepository escolaRepository;

	@RequestMapping(value = "/escola", method = RequestMethod.GET)
	public List<Escola> Get() {
		return escolaRepository.findAll();
	}

	@RequestMapping(value = "/escola/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Escola> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Escola> escola = escolaRepository.findById(codigo);
		if (escola.isPresent())
			return new ResponseEntity<Escola>(escola.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/escola", method = RequestMethod.POST)
	public Escola Post(@Valid @RequestBody Escola escola) {
		return escolaRepository.save(escola);
	}

	@RequestMapping(value = "/escola/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Escola> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Escola newEscola) {
		Optional<Escola> oldEscola = escolaRepository.findById(codigo);
		if (oldEscola.isPresent()) {
			Escola escola = oldEscola.get();
			escola.setNome(newEscola.getNome());
			escolaRepository.save(escola);
			return new ResponseEntity<Escola>(escola, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/escola/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Escola> escola = escolaRepository.findById(codigo);
		if (escola.isPresent()) {
			escolaRepository.delete(escola.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

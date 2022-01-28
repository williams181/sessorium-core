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

import br.ifpe.com.Model.Endereco;
import br.ifpe.com.Repository.EnderecoRepository;
import br.ifpe.com.Service.EnderecoService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class EnderecoResourse {
	
	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@RequestMapping(value = "/enderecos", method = RequestMethod.GET)
	public List<Endereco> Get() {
		return enderecoRepository.findAll();
	}

	@RequestMapping(value = "/enderecoId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Endereco> endereco = enderecoRepository.findById(codigo);
		if (endereco.isPresent())
			return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/enderecoCep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> GetByTitulo(@PathVariable(value = "cep") String cep) {
		Optional<Endereco> endereco = enderecoRepository.findByCep(cep);
		if (endereco.isPresent())
			return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/endereco", method = RequestMethod.POST)
	public Endereco Post(@Valid Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	@RequestMapping(value = "/endereco/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Endereco> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Endereco newEndereco) {
		Optional<Endereco> oldEndereco = enderecoRepository.findById(codigo);
		if (oldEndereco.isPresent()) {
			Endereco endereco = oldEndereco.get();
			endereco.setCep(newEndereco.getCep());
			enderecoRepository.save(endereco);
			return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/endereco/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Endereco> endereco = enderecoRepository.findById(codigo);
		if (endereco.isPresent()) {
			enderecoRepository.delete(endereco.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

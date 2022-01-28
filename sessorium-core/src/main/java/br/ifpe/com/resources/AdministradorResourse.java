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

import br.ifpe.com.Model.Administrador;
import br.ifpe.com.Repository.AdministradorRepository;
import br.ifpe.com.Service.AdministradorService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class AdministradorResourse {
	
	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private AdministradorRepository administradorRepository;

	@RequestMapping(value = "/administradores", method = RequestMethod.GET)
	public List<Administrador> Get() {
		return administradorRepository.findAll();
	}
	

	@RequestMapping(value = "/administradorId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Administrador> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Administrador> administrador = administradorRepository.findById(codigo);
		if (administrador.isPresent())
			return new ResponseEntity<Administrador>(administrador.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/administradorEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<Administrador> GetByEmail(@PathVariable(value = "email") String email) {
		Optional<Administrador> administrador = administradorRepository.findByEmail(email);
		if (administrador.isPresent())
			return new ResponseEntity<Administrador>(administrador.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/administrador", method = RequestMethod.POST)
	public Administrador Post(@Valid Administrador administrador) {
		return administradorRepository.save(administrador);
	}

	@RequestMapping(value = "/administrador/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Administrador> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Administrador newAdministrador) {
		Optional<Administrador> oldAdministrador = administradorRepository.findById(codigo);
		if (oldAdministrador.isPresent()) {
			Administrador administrador = oldAdministrador.get();
			administrador.setNome(newAdministrador.getNome());
			administradorRepository.save(administrador);
			return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/administrador/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Administrador> administrador = administradorRepository.findById(codigo);
		if (administrador.isPresent()) {
			administradorRepository.delete(administrador.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

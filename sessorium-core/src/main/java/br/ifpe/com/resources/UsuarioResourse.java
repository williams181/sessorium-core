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

import br.ifpe.com.Model.Usuario;
import br.ifpe.com.Repository.UsuarioRepository;
import br.ifpe.com.Service.UsuarioService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class UsuarioResourse {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<Usuario> Get() {
		return usuarioRepository.findAll();
	}

	@RequestMapping(value = "/usuarioId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Usuario> usuario = usuarioRepository.findById(codigo);
		if (usuario.isPresent())
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/usuarioEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> GetByEmail(@PathVariable(value = "email") String email) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		if (usuario.isPresent())
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public Usuario Post(@Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@RequestMapping(value = "/usuario/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Usuario newUsuario) {
		Optional<Usuario> oldUsuario = usuarioRepository.findById(codigo);
		if (oldUsuario.isPresent()) {
			Usuario usuario = oldUsuario.get();
			usuario.setNome(newUsuario.getNome());
			usuarioRepository.save(usuario);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/usuario/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Usuario> usuario = usuarioRepository.findById(codigo);
		if (usuario.isPresent()) {
			usuarioRepository.delete(usuario.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

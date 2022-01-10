package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.ifpe.com.Model.Usuario;
import br.ifpe.com.Repository.UsuarioRepository;

public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
}

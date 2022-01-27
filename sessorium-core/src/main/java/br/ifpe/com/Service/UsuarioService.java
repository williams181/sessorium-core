package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Usuario;
import br.ifpe.com.Repository.UsuarioRepository;
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void inserirUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void removerUsuario(Integer codigo) {
		usuarioRepository.deleteById(codigo);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuario(Integer codigo) {
		return usuarioRepository.findById(codigo).get();
	}

}

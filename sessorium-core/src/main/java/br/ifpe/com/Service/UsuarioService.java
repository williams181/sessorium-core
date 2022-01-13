package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.UsuarioDao;
import br.ifpe.com.Model.Usuario;
@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao daoUsuario;

	public void inserirUsuario(Usuario usuario) {
		daoUsuario.save(usuario);
	}

	public void removerUsuario(Integer codigo) {
		daoUsuario.deleteById(codigo);
	}

	public List<Usuario> listarUsuarios() {
		return daoUsuario.findAll();
	}

	public Usuario buscarUsuario(Integer codigo) {
		return daoUsuario.findById(codigo).get();
	}

}

package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.ComentarioDao;
import br.ifpe.com.Model.Comentario;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioDao daoComentario;

	public void inserirComentario(Comentario comentario) {
		daoComentario.save(comentario);
	}

	public void removerComentario(Integer codigo) {
		daoComentario.deleteById(codigo);
	}

	public List<Comentario> listarComentarios() {
		return daoComentario.findAll();
	}

	public Comentario buscarComentario(Integer codigo) {
		return daoComentario.findById(codigo).get();
	}
}

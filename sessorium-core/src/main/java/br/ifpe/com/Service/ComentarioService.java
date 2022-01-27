package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Comentario;
import br.ifpe.com.Repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	public void inserirComentario(Comentario comentario) {
		comentarioRepository.save(comentario);
	}

	public void removerComentario(Integer codigo) {
		comentarioRepository.deleteById(codigo);
	}

	public List<Comentario> listarComentarios() {
		return comentarioRepository.findAll();
	}

	public Comentario buscarComentario(Integer codigo) {
		return comentarioRepository.findById(codigo).get();
	}
}

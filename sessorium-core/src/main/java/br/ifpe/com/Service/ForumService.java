package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Forum;
import br.ifpe.com.Repository.ForumRepository;
@Service
public class ForumService {
	
	@Autowired
	private ForumRepository forumRepository;

	public void inserirForum(Forum forum) {
		forumRepository.save(forum);
	}

	public void removerForum(Integer codigo) {
		forumRepository.deleteById(codigo);
	}

	public List<Forum> listarForums() {
		return forumRepository.findAll();
	}

	public Forum buscarForum(Integer codigo) {
		return forumRepository.findById(codigo).get();
	}

}

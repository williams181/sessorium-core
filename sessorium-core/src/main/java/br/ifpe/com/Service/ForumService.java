package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.ForumDao;
import br.ifpe.com.Model.Forum;
@Service
public class ForumService {
	
	@Autowired
	private ForumDao daoForum;

	public void inserirForum(Forum forum) {
		daoForum.save(forum);
	}

	public void removerForum(Integer codigo) {
		daoForum.deleteById(codigo);
	}

	public List<Forum> listarForums() {
		return daoForum.findAll();
	}

	public Forum buscarForum(Integer codigo) {
		return daoForum.findById(codigo).get();
	}

}

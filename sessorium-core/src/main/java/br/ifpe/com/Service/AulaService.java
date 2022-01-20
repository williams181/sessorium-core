package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.AulaDao;
import br.ifpe.com.Model.Aula;

@Service
public class AulaService {

	@Autowired
	private AulaDao daoAula;

	public void inserirAula(Aula aula) {
		daoAula.save(aula);
	}

	public void removerAula(Integer codigo) {
		daoAula.deleteById(codigo);
	}

	public List<Aula> listarAulas() {
		return daoAula.findAll();
	}

	public Aula buscarAula(Integer codigo) {
		return daoAula.findById(codigo).get();
	}

}

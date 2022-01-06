package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.EscolaDao;
import br.ifpe.com.Model.Escola;

@Service
public class EscolaService {

	@Autowired
	private EscolaDao daoEscola;

	public void inserirEscola(Escola escola) {
		daoEscola.save(escola);
	}

	public void removerEscola(Integer codigo) {
		daoEscola.deleteById(codigo);
	}

	public List<Escola> listarEscolas() {
		return daoEscola.findAll();
	}

	public Escola buscarEscola(Integer codigo) {
		return daoEscola.findById(codigo).get();
	}
}

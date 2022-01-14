package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.AtividadeDao;
import br.ifpe.com.Model.Atividade;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeDao daoAtividade;

	public void inserirAtividade(Atividade atividade) {
		daoAtividade.save(atividade);
	}

	public void removerAtividade(Integer codigo) {
		daoAtividade.deleteById(codigo);
	}

	public List<Atividade> listarAtividades() {
		return daoAtividade.findAll();
	}

	public Atividade buscarAtividade(Integer codigo) {
		return daoAtividade.findById(codigo).get();
	}
}

package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Atividade;
import br.ifpe.com.Repository.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;

	public void inserirAtividade(Atividade atividade) {
		atividadeRepository.save(atividade);
	}

	public void removerAtividade(Integer codigo) {
		atividadeRepository.deleteById(codigo);
	}

	public List<Atividade> listarAtividades() {
		return atividadeRepository.findAll();
	}

	public Atividade buscarAtividade(Integer codigo) {
		return atividadeRepository.findById(codigo).get();
	}
}

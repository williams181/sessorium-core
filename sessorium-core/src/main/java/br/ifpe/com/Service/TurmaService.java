package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Turma;
import br.ifpe.com.Repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public void inserirTurma(Turma turma) {
		turmaRepository.save(turma);
	}

	public void removerTurma(Integer codigo) {
		turmaRepository.deleteById(codigo);
	}

	public List<Turma> listarTurmas() {
		return turmaRepository.findAll();
	}

	public Turma buscarTurma(Integer codigo) {
		return turmaRepository.findById(codigo).get();
	}

}

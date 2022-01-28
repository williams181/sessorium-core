package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Endereco;
import br.ifpe.com.Repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public void inserirEndereco(Endereco endereco) {
		enderecoRepository.save(endereco);
	}

	public void removerEndereco(Integer codigo) {
		enderecoRepository.deleteById(codigo);
	}

	public List<Endereco> listarEnderecos() {
		return enderecoRepository.findAll();
	}

	public Endereco buscarEndereco(Integer codigo) {
		return enderecoRepository.findById(codigo).get();
	}
}

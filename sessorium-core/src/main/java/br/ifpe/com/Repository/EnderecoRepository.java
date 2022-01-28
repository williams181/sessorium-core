package br.ifpe.com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	public Optional<Endereco> findByCep(String cep);
	
}


package br.ifpe.com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {

	public Optional<Aula> findByTitulo(String titulo);
	
}


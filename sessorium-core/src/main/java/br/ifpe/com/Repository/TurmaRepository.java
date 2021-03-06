package br.ifpe.com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Turma;
@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

	public Optional<Turma> findByTitulo(String titulo);
	
}

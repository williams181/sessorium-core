package br.ifpe.com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Professor;
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

	public Optional<Professor> findByEmail(String email);

}

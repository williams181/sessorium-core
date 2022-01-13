package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {


}

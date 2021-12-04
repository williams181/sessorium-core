package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Professor;

@Repository
public interface ProfessorDao extends JpaRepository<Professor, String> {

}

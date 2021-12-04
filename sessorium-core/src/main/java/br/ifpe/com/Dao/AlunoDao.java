package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Aluno;

@Repository
public interface AlunoDao extends JpaRepository<Aluno, String> {

}

package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Turma;

@Repository
public interface TurmaDao extends JpaRepository<Turma, String> {

}

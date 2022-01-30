package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Atividade;

@Repository
public interface AtividadeDao extends JpaRepository<Atividade, Integer> {

}

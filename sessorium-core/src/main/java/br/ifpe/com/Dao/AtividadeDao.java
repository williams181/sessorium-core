package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Atividade;

public interface AtividadeDao extends JpaRepository<Atividade, Integer> {

}

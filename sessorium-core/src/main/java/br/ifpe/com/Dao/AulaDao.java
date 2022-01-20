package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Aula;

@Repository
public interface AulaDao extends JpaRepository<Aula, Integer> {

}

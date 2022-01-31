package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Entrega;

@Repository
public interface EntregaDao extends JpaRepository<Entrega, Integer> {

}

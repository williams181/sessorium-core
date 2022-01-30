package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Coordenador;

@Repository
public interface CoordenadorDao extends JpaRepository<Coordenador, Integer> {

}

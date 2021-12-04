package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Pais;

@Repository
public interface PaisDao extends JpaRepository<Pais, String> {

}

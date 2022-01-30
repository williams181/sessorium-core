package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Administrador;

@Repository
public interface AdministradorDao extends JpaRepository<Administrador, Integer> {

}

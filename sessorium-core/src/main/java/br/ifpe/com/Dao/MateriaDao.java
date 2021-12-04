package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Materia;

@Repository
public interface MateriaDao extends JpaRepository<Materia, String> {

}

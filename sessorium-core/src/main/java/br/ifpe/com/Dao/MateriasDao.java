package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Materias;

	@Repository
	public interface MateriasDao extends JpaRepository <Materias, String> {
	
		

}

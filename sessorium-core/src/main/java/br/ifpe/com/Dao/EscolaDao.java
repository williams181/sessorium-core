package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Escola;

	@Repository
	public interface EscolaDao extends JpaRepository <Escola, String> {
		
}

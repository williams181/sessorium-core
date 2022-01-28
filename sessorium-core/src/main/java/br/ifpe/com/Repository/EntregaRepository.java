package br.ifpe.com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer>{

	public Optional<Entrega> findByTitulo(String titulo);
	
}

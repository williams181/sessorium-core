package br.ifpe.com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Boletim;

@Repository
public interface BoletimRepository extends JpaRepository<Boletim, Integer> {

	public Optional<Boletim> findByTitulo(String titulo);
	
}

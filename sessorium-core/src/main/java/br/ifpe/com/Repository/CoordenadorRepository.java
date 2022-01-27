package br.ifpe.com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Coordenador;
@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer> {

	public Optional<Coordenador> findByEmail(String email);

}

package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Escola;
@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer> {

}

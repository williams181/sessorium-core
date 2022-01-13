package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {

}

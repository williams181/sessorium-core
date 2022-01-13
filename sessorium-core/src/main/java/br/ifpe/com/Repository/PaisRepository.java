package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

}

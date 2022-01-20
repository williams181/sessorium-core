package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Pais;
@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}

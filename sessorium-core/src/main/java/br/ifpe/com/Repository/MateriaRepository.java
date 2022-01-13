package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {

}

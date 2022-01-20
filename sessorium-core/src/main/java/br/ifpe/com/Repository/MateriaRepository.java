package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Materia;
@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

}

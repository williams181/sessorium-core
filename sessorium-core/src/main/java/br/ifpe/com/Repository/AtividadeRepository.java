package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{

}

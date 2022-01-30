package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Comentario;
@Repository
public interface ComentarioDao extends JpaRepository<Comentario, Integer> {

}

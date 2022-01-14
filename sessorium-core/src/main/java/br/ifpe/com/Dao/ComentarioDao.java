package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Comentario;

public interface ComentarioDao extends JpaRepository<Comentario, Integer> {

}

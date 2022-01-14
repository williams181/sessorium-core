package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}

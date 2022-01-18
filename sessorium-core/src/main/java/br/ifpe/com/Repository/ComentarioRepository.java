package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Comentario;
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}

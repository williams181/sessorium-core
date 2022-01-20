package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

}

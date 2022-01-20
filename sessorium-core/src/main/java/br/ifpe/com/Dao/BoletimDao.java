package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Boletim;

@Repository
public interface BoletimDao extends JpaRepository<Boletim, Integer> {

}

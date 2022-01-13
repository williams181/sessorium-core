package br.ifpe.com.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

	@Transactional
	public Administrador findByNome(String nome);
}

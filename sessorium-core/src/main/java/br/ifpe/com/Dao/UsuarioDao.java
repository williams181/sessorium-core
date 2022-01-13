package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {



}

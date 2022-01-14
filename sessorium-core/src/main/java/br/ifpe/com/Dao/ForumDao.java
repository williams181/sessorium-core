package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Forum;

public interface ForumDao extends JpaRepository<Forum, Integer> {

}

package br.ifpe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Forum;
@Repository
public interface ForumDao extends JpaRepository<Forum, Integer> {

}

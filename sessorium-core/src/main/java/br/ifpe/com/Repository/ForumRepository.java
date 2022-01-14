package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.com.Model.Forum;

public interface ForumRepository extends JpaRepository<Forum, Integer> {

}

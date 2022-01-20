package br.ifpe.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.com.Model.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Integer> {

}

package br.ifpe.com.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.com.Model.Forum;
import br.ifpe.com.Repository.ForumRepository;
import br.ifpe.com.Service.ForumService;

@CrossOrigin(origins = {"http://localhost:19006"})
@RestController
@RequestMapping(value = "/sessorium")
public class ForumResourse {

	@Autowired
	private ForumService forumService;
	
	@Autowired
	private ForumRepository forumRepository;

	@RequestMapping(value = "/forums", method = RequestMethod.GET)
	public List<Forum> Get() {
		return forumRepository.findAll();
	}

	@RequestMapping(value = "/forumId/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Forum> GetById(@PathVariable(value = "codigo") int codigo) {
		Optional<Forum> forum = forumRepository.findById(codigo);
		if (forum.isPresent())
			return new ResponseEntity<Forum>(forum.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/forumTema/{tema}", method = RequestMethod.GET)
	public ResponseEntity<Forum> GetByTema(@PathVariable(value = "tema") String tema) {
		Optional<Forum> forum = forumRepository.findByTema(tema);
		if (forum.isPresent())
			return new ResponseEntity<Forum>(forum.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	//@Valid @RequestBody 
	@RequestMapping(value = "/forum", method = RequestMethod.POST)
	public Forum Post(Forum forum) {
		return forumRepository.save(forum);
	}

	@RequestMapping(value = "/forum/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Forum> Put(@PathVariable(value = "codigo") int codigo,
			@Valid @RequestBody Forum newForum) {
		Optional<Forum> oldForum = forumRepository.findById(codigo);
		if (oldForum.isPresent()) {
			Forum forum = oldForum.get();
			forum.setTema(newForum.getTema());
			forumRepository.save(forum);
			return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/forum/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") int codigo) {
		Optional<Forum> forum = forumRepository.findById(codigo);
		if (forum.isPresent()) {
			forumRepository.delete(forum.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

package br.ifpe.com.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.com.Service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResourse {
	
	@Autowired
	private UsuarioService service;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<UsuarioDTO>> findAll() {
//		List<Usuario> list = service.findAll();
//		List<UsuarioDTO> listDto = list.stream().map(UsuarioDTO::new).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDto);
//	}

}

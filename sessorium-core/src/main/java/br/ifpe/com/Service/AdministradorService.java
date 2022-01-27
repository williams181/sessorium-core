package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Administrador;
import br.ifpe.com.Repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;

	public void inserirAdministrador(Administrador administrador) {
		administradorRepository.save(administrador);
	}

	public void removerAdministrador(Integer codigo) {
		administradorRepository.deleteById(codigo);
	}

	public List<Administrador> listarAdministradores() {
		return administradorRepository.findAll();
	}

	public Administrador buscarAdministrador(Integer codigo) {
		return administradorRepository.findById(codigo).get();
	}

}

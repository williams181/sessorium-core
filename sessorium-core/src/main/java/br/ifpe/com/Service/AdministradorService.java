package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.AdministradorDao;
import br.ifpe.com.Model.Administrador;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorDao daoAdministrador;

	public void inserirAdministrador(Administrador administrador) {
		daoAdministrador.save(administrador);
	}

	public void removerAdministrador(Integer codigo) {
		daoAdministrador.deleteById(codigo);
	}

	public List<Administrador> listarAdministradores() {
		return daoAdministrador.findAll();
	}

	public Administrador buscarAdministrador(Integer codigo) {
		return daoAdministrador.findById(codigo).get();
	}
}

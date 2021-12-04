package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.AdministradorDao;
import br.ifpe.com.Model.Administrador;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorDao daoAdministrador;

	public void inserirAdministrador(Administrador administrador) {
		this.daoAdministrador.save(administrador);
	}
	
	public void removerAdministrador(Administrador administrador) {
		this.daoAdministrador.delete(administrador);
	}
	
	
}

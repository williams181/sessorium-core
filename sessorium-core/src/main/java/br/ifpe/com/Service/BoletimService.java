package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.BoletimDao;
import br.ifpe.com.Model.Boletim;

@Service
public class BoletimService {

	@Autowired
	private BoletimDao daoBoletim;

	public void inserirBoletim(Boletim boletim) {
		daoBoletim.save(boletim);
	}

	public void removerBoletim(Integer codigo) {
		daoBoletim.deleteById(codigo);
	}

	public List<Boletim> listarBoletims() {
		return daoBoletim.findAll();
	}

	public Boletim buscarBoletim(Integer codigo) {
		return daoBoletim.findById(codigo).get();
	}

}

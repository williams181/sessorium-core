package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.MateriasDao;
import br.ifpe.com.Model.Materias;

	@Service
	public class MateriasService {

		@Autowired
		private MateriasDao daoMaterias;
		
		public void inserirMaterias(Materias materias) {
			this.daoMaterias.save(materias);
		}
}

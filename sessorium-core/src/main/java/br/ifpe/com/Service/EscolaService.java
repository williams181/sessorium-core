package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.EscolaDao;
import br.ifpe.com.Model.Escola;

	@Service
	public class EscolaService {

		@Autowired
		private EscolaDao daoEscola;
		
		public void inserirEscola(Escola escola) {
			this.daoEscola.save(escola);
		}
}

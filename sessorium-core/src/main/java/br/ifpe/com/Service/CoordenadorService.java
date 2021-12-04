package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.CoordenadorDao;
import br.ifpe.com.Model.Coordenador;

	@Service
	public class CoordenadorService {
		
		@Autowired 
		private CoordenadorDao daoCoordenador;
		
		public void inserirCoordenador(Coordenador coordenador) {
			this.daoCoordenador.save(coordenador);
		}

}

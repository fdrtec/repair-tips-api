package br.com.fdrtec.api.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fdrtec.api.daos.DicaDao;
import br.com.fdrtec.api.entities.Dica;

@Stateless
public class DicaService {

	@Inject
	private DicaDao dicaDao;

	public List<Dica> getAll() {
		return dicaDao.getAll();
	}

	public void persist(Dica dica) {
		dicaDao.persist(dica);
	}
	
	public void update(Dica dica) {
		dicaDao.update(dica);
	}
	
	public void remove(Long id) {
		dicaDao.remove(id);
	}	

}

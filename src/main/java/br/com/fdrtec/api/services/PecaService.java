package br.com.fdrtec.api.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fdrtec.api.daos.PecaDao;
import br.com.fdrtec.api.entities.Peca;

@Stateless
public class PecaService {
	
	@Inject
	private PecaDao pecaDao;
	
	public List<Peca> getAll(){
		return pecaDao.getAll();		
	}
	
	public void persist(Peca peca) {
		pecaDao.persist(peca);
	}
	
	public void update(Peca peca) {
		pecaDao.update(peca);
	}
	
	public void remove(Peca peca) {
		pecaDao.remove(peca.getId());
	}
	
}

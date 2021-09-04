package br.com.fdrtec.api.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fdrtec.api.daos.VeiculoDao;
import br.com.fdrtec.api.entities.Veiculo;

@Stateless
public class VeiculoService {
	
	@Inject
	private VeiculoDao veiculoDao;
	
	public List<Veiculo> getAll() {
		return veiculoDao.getAll();		
	}
	
	public void create(Veiculo veiculo) {
		veiculoDao.create(veiculo);		
	}
	
	public void update(Veiculo veiculo) {
		veiculoDao.update(veiculo);
	}
	
	public void delete(Long id) {
		veiculoDao.delete(id);
	}

}

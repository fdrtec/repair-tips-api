package br.com.fdrtec.api.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fdrtec.api.entities.Veiculo;

@Stateless
public class VeiculoDao {

	@PersistenceContext
	EntityManager entityManager;

	public List<Veiculo> getAll() {
		return entityManager.createQuery("SELECT tb_veiculo FROM Veiculo tb_veiculo", Veiculo.class).getResultList();
	}
	
	public void create(Veiculo veiculo) {
		entityManager.persist(veiculo);
	}
	
	public void update(Veiculo veiculo) {
		Veiculo candidato = entityManager.find(Veiculo.class, veiculo.getId());
		candidato = veiculo;
		entityManager.merge(candidato);
	}
	
	public void delete(Long id) {
		Veiculo veiculo = entityManager.find(Veiculo.class, id);
		entityManager.remove(veiculo);
	}

}

package br.com.fdrtec.api.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fdrtec.api.entities.Peca;

@Stateless
public class PecaDao {
	
	@PersistenceContext
	EntityManager em;
	
	
	public List<Peca> getAll() {
		String query = "SELECT itens FROM Peca itens";
		return em.createQuery(query, Peca.class).getResultList();
	}
	
	public void persist(Peca item) {
		em.persist(item);		
	}
	
	public void update (Peca itemAtualizado) {
		Peca candidato = em.find(Peca.class, itemAtualizado.getId());
		candidato = itemAtualizado;
		em.merge(candidato);
	}
	
	public void remove(Long id) {
		Peca candidato = em.find(Peca.class, id);
		em.remove(candidato);
	}
}

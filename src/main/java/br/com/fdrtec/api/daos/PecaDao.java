package br.com.fdrtec.api.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fdrtec.api.entities.Peca;

@Stateless
public class PecaDao {
	
	@PersistenceContext
	EntityManager em;
	
	
	public List<Peca> getAll() {		
		String sql = "select p from Peca p left join fetch p.dicas";
		TypedQuery<Peca> query = em.createQuery(sql, Peca.class);
		return query.getResultList();
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

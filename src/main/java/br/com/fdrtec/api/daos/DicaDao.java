package br.com.fdrtec.api.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.fdrtec.api.entities.Dica;
import br.com.fdrtec.api.entities.Peca;

@Stateless
public class DicaDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Dica> getAll(){		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Dica> criteriaQuery = criteriaBuilder.createQuery(Dica.class);
		Root<Dica> root = criteriaQuery.from(Dica.class);
		criteriaQuery.select(root);

		TypedQuery<Dica> typedQuery = em.createQuery(criteriaQuery);
		return typedQuery.getResultList();		
	}

	// public List<Dica> getAll(){		
	// 	String sql = "select distinct d from Dica d left join fetch d.pecas";
	// 	TypedQuery<Dica> query = em.createQuery(sql, Dica.class);
	// 	return query.getResultList();
	// }
	
	public Dica getById(Long id) {
		return em.find(Dica.class, id);
	}
	
	public void persist(Dica item) {
		em.persist(item);		
	}
	
	public void update(Dica itemAtualizado) {
		Dica candidato = em.find(Dica.class, itemAtualizado.getId());		
		candidato = itemAtualizado;
		em.merge(candidato);
		em.flush();
	}
	
	public void remove(Long id) {
		Dica candidato = em.find(Dica.class, id);
		candidato.getPecas().clear(); 
		em.merge(candidato);
		em.flush();
		em.remove(candidato);
	}
}

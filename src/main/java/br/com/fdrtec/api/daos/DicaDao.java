package br.com.fdrtec.api.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fdrtec.api.entities.Dica;

@Stateless
public class DicaDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Dica> getAll(){
		String query = "select d from Dica d";
		return em.createQuery(query, Dica.class).getResultList();		
	}
	
	public void persist(Dica item) {
		em.persist(item);		
	}
	
	public void update(Dica itemAtualizado) {
		Dica candidato = em.find(Dica.class, itemAtualizado.getId());
		candidato = itemAtualizado;
		em.merge(candidato);
	}
	
	public void remove(Long id) {
		Dica candidato = em.find(Dica.class, id);
		em.remove(candidato);
	}

}

package br.com.fdrtec.api.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fdrtec.api.entities.Dica;
import br.com.fdrtec.api.entities.Peca;

@Stateless
public class DicaDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Dica> getAll(){		
		String sql = "select d from Dica d";
		TypedQuery<Dica> query = em.createQuery(sql, Dica.class);
		return query.getResultList();
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
		for (Peca peca : candidato.getPecas()) {
		    candidato.removePeca(peca);
		}
//		candidato.setPecas(null);
		em.remove(candidato);
	}

}

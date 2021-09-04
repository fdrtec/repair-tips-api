package br.com.fdrtec.api.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fdrtec.api.entities.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<AgendamentoEmail> listar() {
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae", AgendamentoEmail.class)
				.getResultList();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail){
		entityManager.persist(agendamentoEmail);		
	}
}

package br.com.fdrtec.api.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fdrtec.api.daos.AgendamentoEmailDao;
import br.com.fdrtec.api.entities.AgendamentoEmail;

@Stateless
public class AgendamentoEmailService {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;

	public List<AgendamentoEmail> listar() {
		return agendamentoEmailDao.listar();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(false);
		agendamentoEmailDao.inserir(agendamentoEmail);
	}

}

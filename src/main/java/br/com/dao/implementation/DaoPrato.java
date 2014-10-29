package br.com.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoPrato;
import br.com.models.Prato;

@Repository
@Transactional
public class DaoPrato extends AbstractHibernateDao<Prato> implements IDaoPrato {
	
	public DaoPrato() {
		super();
		super.setClasse(Prato.class);
	}

	public void cadastrar(Prato prato) {
		// TODO Auto-generated method stub
		
	}

	public List<Prato> getPratos() {
		return super.findAll();
	}

}

package br.com.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoPagamento;
import br.com.models.Pagamento;

@Repository
@Transactional
public class DaoPagamento extends AbstractHibernateDao<Pagamento> implements IDaoPagamento {
	
	public DaoPagamento() {
		super();
		super.setClasse(Pagamento.class);
	}

	public void cadastrar(Pagamento pagamento) {
		super.save(pagamento);
	}

}

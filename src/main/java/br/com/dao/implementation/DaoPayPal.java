package br.com.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoPayPal;
import br.com.models.PayPal;

@Repository
@Transactional
public class DaoPayPal extends AbstractHibernateDao<PayPal> implements IDaoPayPal {
	
	public DaoPayPal() {
		super();
		super.setClasse(PayPal.class);
	}

	public void cadastrar(PayPal payPal) {
		super.save(payPal);
	}
}

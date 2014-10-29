package br.com.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoCartao;
import br.com.models.Cartao;
import br.com.models.Cliente;

@Repository
@Transactional
public class DaoCartao extends AbstractHibernateDao<Cartao> implements IDaoCartao {

	public DaoCartao() {
		super();
		super.setClasse(Cartao.class);
	}
	
	public void cadastrar(Cartao cartao) {
		super.save(cartao);
	}

	public List<Cartao> getCartoes(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}

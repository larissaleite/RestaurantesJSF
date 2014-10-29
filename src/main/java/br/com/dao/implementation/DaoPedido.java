package br.com.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoPedido;
import br.com.models.Cliente;
import br.com.models.Pedido;

@Repository
@Transactional
public class DaoPedido extends AbstractHibernateDao<Pedido> implements IDaoPedido {

	public DaoPedido() {
		super();
		super.setClasse(Pedido.class);
	}
	
	public void cadastrar(Pedido pedido) {
		super.save(pedido);
	}

	public void getPedidos(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

}

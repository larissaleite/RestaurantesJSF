package br.com.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoPedido;
import br.com.models.Cliente;
import br.com.models.Pedido;
import br.com.models.PedidoItem;

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Pedido> getPedidos(Cliente cliente) {
		
		List pedido = super.hqlQuery("SELECT * from pedido WHERE cliente_id = "+cliente.getId()+";");
		List<Pedido> pedidosCliente = new ArrayList<Pedido>();
		
		for (Object object : pedido) {
			Pedido p = new Pedido();
			Map map = (Map) object;
			
			p.setId(Integer.parseInt(map.get("id_pedido").toString()));
			p.setPratos((List<PedidoItem>) map.get("pratos"));
			
			pedidosCliente.add(p);
		}
		
		return pedidosCliente;
	}

	public List<Pedido> getPedidos() {
		return super.findAll();
	}

}

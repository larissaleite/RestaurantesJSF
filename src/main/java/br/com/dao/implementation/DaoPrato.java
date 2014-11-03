package br.com.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoPrato;
import br.com.models.Cliente;
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
	
	public Prato getPrato(int id) {
		return super.findOne(id);
	}

	public List<Prato> getPratos() {
		return super.findAll();
	}
	
	@SuppressWarnings("rawtypes")
	public List<Prato> getPratosPorPedido() {
		List pratos = super.hqlQuery("SELECT prato_id, COUNT(prato_id) as c FROM pedidoitem group by prato_id;");
		List quantPedidos = super.hqlQuery("SELECT * FROM pedido;");
		
		int quant = quantPedidos.size();
		
		List<Prato> pratosQuantidade = new ArrayList<Prato>();
		
		for (Object object : pratos) {
			Map map = (Map) object;
			if (Integer.parseInt(map.get("c").toString()) >= quant/3) {
				Prato prato = getPrato(Integer.parseInt(map.get("prato_id").toString()));
				pratosQuantidade.add(prato);
			}
		}
		
		return pratosQuantidade;
	}

	@SuppressWarnings("rawtypes")
	public List<Prato> getPratosCliente(Cliente cliente) {
		List pedidos = super.hqlQuery("SELECT id_pedido FROM pedido WHERE cliente_id = "+cliente.getId()+";");
		//int quant = pedidos.size();
		
		List<Prato> pratosCliente = new ArrayList<Prato>();
		
		for (Object object : pedidos) {
			Map map = (Map) object;
			int pedido_id = Integer.parseInt(map.get("id_pedido").toString());
			List pratos = super.hqlQuery("SELECT prato_id FROM pedidoitem WHERE pedido_id="+pedido_id+";");
			
			for (Object obj : pratos) {
				Map m = (Map) obj;
				Prato prato = getPrato(Integer.parseInt(m.get("prato_id").toString()));
				pratosCliente.add(prato);
			}
		}
		
		return pratosCliente;
	}

}

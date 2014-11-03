package br.com.dao.interfaces;

import java.util.List;

import br.com.models.Cliente;
import br.com.models.Pedido;

public interface IDaoPedido {
	
	public void cadastrar (Pedido pedido);
	public List<Pedido> getPedidos (Cliente cliente);
	public List<Pedido> getPedidos ();
	
}

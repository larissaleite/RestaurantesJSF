package br.com.dao.interfaces;

import br.com.models.Cliente;
import br.com.models.Pedido;

public interface IDaoPedido {
	
	public void cadastrar (Pedido pedido);
	public void getPedidos (Cliente cliente);
	
}

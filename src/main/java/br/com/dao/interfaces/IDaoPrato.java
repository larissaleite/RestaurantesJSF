package br.com.dao.interfaces;

import java.util.List;

import br.com.models.Cliente;
import br.com.models.Prato;

public interface IDaoPrato {
	public void cadastrar (Prato prato);
	public List<Prato> getPratos();
	public Prato getPrato(int id);
	public List<Prato> getPratosPorPedido();
	public List<Prato> getPratosCliente(Cliente cliente);
}

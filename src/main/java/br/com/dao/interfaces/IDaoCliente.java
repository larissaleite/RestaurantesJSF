package br.com.dao.interfaces;

import br.com.models.Cliente;

public interface IDaoCliente {
	
	public void cadastrar(Cliente cliente);
	public boolean autenticar(String email, String senha);
	public Cliente getCliente(String email);
	
}

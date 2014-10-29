package br.com.dao.interfaces;

import java.util.List;

import br.com.models.Cartao;
import br.com.models.Cliente;

public interface IDaoCartao {
	
	public void cadastrar (Cartao cartao);
	public List<Cartao> getCartoes (Cliente cliente);
}

package br.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.interfaces.IDaoCartao;
import br.com.dao.interfaces.IDaoCliente;
import br.com.dao.interfaces.IDaoPedido;
import br.com.dao.interfaces.IDaoPrato;
import br.com.models.Cartao;
import br.com.models.Cliente;
import br.com.models.Pedido;
import br.com.models.Prato;

@Service("pedidoService")
public class RestauranteService {
	
	@Autowired
	private IDaoCliente daoCliente;
	
	@Autowired
	private IDaoPrato daoPrato;
	
	@Autowired
	private IDaoCartao daoCartao;
	
	@Autowired
	private IDaoPedido daoPedido;
	
	public void cadastrarCliente(Cliente cliente) {
		daoCliente.cadastrar(cliente);
	}
	
	public boolean autenticar(Cliente cliente) {
		return daoCliente.autenticar(cliente.getEmail(), cliente.getSenha());
	}
	
	public List<Prato> getPratos() {
		return daoPrato.getPratos();
	}
	
	public Cliente getCliente(String email) {
		return daoCliente.getCliente(email);
	}
	
	public void cadastrarCartao(Cartao cartao) {
		daoCartao.cadastrar(cartao);
	}
	
	public void cadastrarPedido(Pedido pedido) {
		daoPedido.cadastrar(pedido);
	}
	
}

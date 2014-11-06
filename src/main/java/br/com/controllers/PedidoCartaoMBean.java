package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.models.Cartao;
import br.com.models.Pagamento;
import br.com.services.PagamentoCartao;
import br.com.services.PagamentoStrategy;

@Controller
public class PedidoCartaoMBean extends PedidoMBean {
	
	private Cartao cartao;
	
	public PedidoCartaoMBean() {
		cartao = new Cartao();
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public void confirmarPagamento() {
		this.pagamentoService.pagamento(total, new PagamentoCartao(cartao), this.restauranteService);
		//this.restauranteService.cadastrarCartao(cartao);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setCartao(cartao);
		
		super.confirmarPedido(pagamento);
		
	}

}

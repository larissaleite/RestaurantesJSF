package br.com.controllers;

import org.springframework.stereotype.Controller;

import br.com.models.Cartao;
import br.com.models.Pagamento;

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
		//registrar cartao dentro de pagar?
		this.pagamentoService.pagamentoCartao(total, cartao.getNome(), cartao.getNumero(), cartao.getDataVencimento(), cartao.getCodigoSeguranca(), cartao.getTipo());
		this.restauranteService.cadastrarCartao(cartao);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setCartao(cartao);
		
		super.confirmarPedido(pagamento);
		
	}

}

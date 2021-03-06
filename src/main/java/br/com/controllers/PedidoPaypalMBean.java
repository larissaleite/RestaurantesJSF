package br.com.controllers;

import org.springframework.stereotype.Controller;

import br.com.models.Pagamento;
import br.com.models.PayPal;
import br.com.services.PagamentoPayPal;

@Controller
public class PedidoPaypalMBean extends PedidoMBean {
	
	private PayPal payPal;
	
	public PedidoPaypalMBean() {
		payPal = new PayPal();
	}
	
	public PayPal getPayPal() {
		return payPal;
	}

	public void setPayPal(PayPal payPal) {
		this.payPal = payPal;
	}

	public void confirmarPagamento() { 
		this.pagamentoService.pagamento(total, new PagamentoPayPal(payPal), restauranteService);
		//this.restauranteService.cadastrarPayPal(payPal);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setPayPal(payPal);
		
		super.confirmarPedido(pagamento);
	}

}

package br.com.services;

import br.com.models.PayPal;

public class PagamentoPayPal implements PagamentoStrategy {
	
	private PayPal payPal;
	
	public PagamentoPayPal (PayPal payPal) {
		this.payPal = payPal;
	}

	public void pagar(float valor, RestauranteService restauranteService) {
		/* método para validações necessárias */
		restauranteService.cadastrarPayPal(payPal);
	}

}

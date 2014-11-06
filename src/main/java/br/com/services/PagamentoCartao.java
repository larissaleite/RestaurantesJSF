package br.com.services;

import br.com.models.Cartao;

public class PagamentoCartao implements PagamentoStrategy {
	
	private Cartao cartao;
	
	public PagamentoCartao (Cartao cartao) {
		this.cartao = cartao;
	}
	
	public void pagar(float valor, RestauranteService restauranteService) {
		/* método para validações necessárias */
		restauranteService.cadastrarCartao(cartao);
	}

}

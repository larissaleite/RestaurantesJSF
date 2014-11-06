package br.com.services;

import br.com.models.ValeAlimentacao;

public class PagamentoValeAlimentacao implements PagamentoStrategy {
	
	private ValeAlimentacao valeAlimentacao;
	
	public PagamentoValeAlimentacao(ValeAlimentacao valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}

	public void pagar(float valor, RestauranteService restauranteService) {
		/* método para validações necessárias */
		restauranteService.cadastrarValeAlimentacao(valeAlimentacao);
	}

}

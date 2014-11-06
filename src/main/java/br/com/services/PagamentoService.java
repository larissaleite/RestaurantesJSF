package br.com.services;

import org.springframework.stereotype.Service;

@Service("pagamentoService")
public class PagamentoService {
	
	private PagamentoStrategy pagamentoStrategy;
	
	public void pagamento(float valor, PagamentoStrategy pagamentoStrategy, RestauranteService restauranteService) {
		this.pagamentoStrategy = pagamentoStrategy;
		this.pagamentoStrategy.pagar(valor, restauranteService);
	}
	
}

package br.com.services;

public interface PagamentoStrategy {
	
	/**
	 * restauranteService somente é necessário porque os DAOs não conseguem ser injetados facilmente 
	 * pelo Spring nas classes que implementam PagamentoStrategy **/
	public void pagar (float valor, RestauranteService restauranteService);
	
}

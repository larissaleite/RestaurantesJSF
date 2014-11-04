package br.com.services;

import java.util.List;

import br.com.models.Cliente;
import br.com.models.Prato;

public abstract class Recomendador {
	
	//@Autowired
	protected RestauranteService restauranteService;
	
	protected Recomendador sucessor;
	
	public void setSucessor(Recomendador sucessor) {
		this.sucessor = sucessor;
	}
	
	public abstract List<Prato> recomendar (List<Prato> pratos, Cliente cliente);
	
	public void setRestauranteService(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}
	
}

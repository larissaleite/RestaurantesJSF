package br.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.models.Cliente;
import br.com.models.Prato;

@Service("recomendacaoService")
public class RecomendacaoService {
	
	@Autowired
	private RestauranteService restauranteService;
	
	public List<Prato> getPratosRecomendados(Cliente cliente) {
		
		Recomendador recomendadorData = new RecomendadorData();
		Recomendador recomendadorCliente = new RecomendadorCliente();
		Recomendador recomendadorTopPedidos = new RecomendadorTopPedidos();
		
		recomendadorData.setRestauranteService(restauranteService);
		recomendadorCliente.setRestauranteService(restauranteService);
		recomendadorTopPedidos.setRestauranteService(restauranteService);
		
		recomendadorData.setSucessor(recomendadorCliente);
		recomendadorData.setSucessor(recomendadorTopPedidos);
		
		return recomendadorData.recomendar(new ArrayList<Prato>(), cliente);
	}

}

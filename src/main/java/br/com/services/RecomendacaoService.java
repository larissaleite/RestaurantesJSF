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
	
	private Recomendador recomendadorData;
	private Recomendador recomendadorCliente;
	private Recomendador recomendadorTopPedidos;
	
	public List<Prato> getPratosRecomendados(Cliente cliente) {
		
		recomendadorData = new RecomendadorData();
		recomendadorCliente = new RecomendadorCliente();
		recomendadorTopPedidos = new RecomendadorTopPedidos();
		
		recomendadorData.setRestauranteService(restauranteService);
		recomendadorCliente.setRestauranteService(restauranteService);
		recomendadorTopPedidos.setRestauranteService(restauranteService);
		
		recomendadorData.setSucessor(recomendadorCliente);
		recomendadorData.setSucessor(recomendadorTopPedidos);
		
		return recomendadorData.recomendar(new ArrayList<Prato>(), cliente);
	}

}

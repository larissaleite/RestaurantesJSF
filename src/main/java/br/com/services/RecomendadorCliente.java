package br.com.services;

import java.util.List;

import br.com.models.Cliente;
import br.com.models.Prato;

public class RecomendadorCliente extends Recomendador {

	@Override
	public List<Prato> recomendar(List<Prato> pratos, Cliente cliente) {
		
		List<Prato> pratosCliente = this.restauranteService.getPratosCliente(cliente);
		
		for (Prato prato : pratosCliente) {
			boolean existe = false;
			for (Prato p : pratos) {
				if (prato.getId() == p.getId()) {
					existe = true;
				}
			}
			if (!existe)
				pratos.add(prato);
		}
		
		if (this.sucessor != null) {
			return sucessor.recomendar(pratos, cliente);
		}
		
		return pratos;
	}


}

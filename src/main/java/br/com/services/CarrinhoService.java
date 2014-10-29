package br.com.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import br.com.models.Prato;

@Service("serviceCarrinho")
public class CarrinhoService {
	
	private HashMap<Prato, Integer> pratos;
	
	public CarrinhoService() {
		pratos = new HashMap<Prato, Integer>();
	}
	
	public HashMap<Prato, Integer> getPratos() {
		return pratos;
	}

	public void adicionarPratos(Prato prato, int quantidade) {
		for (Prato p : pratos.keySet()) {
			if (p.getNome().equals(prato.getNome())) {
				pratos.put(p, pratos.get(p)+quantidade);
				return;
			}
		}
		
		pratos.put(prato, quantidade);
	}
	
	public void excluirPrato(Prato prato) {
		for (Prato p : pratos.keySet()) {
			if (p.getNome().equals(prato.getNome())) {
				if (pratos.get(p) > 1)
					pratos.put(p, pratos.get(p)-1);
				else
					pratos.remove(p);
			}
		}
	}
	
	public void limparCarrinho() {
		pratos = new HashMap<Prato, Integer>();
	}

}

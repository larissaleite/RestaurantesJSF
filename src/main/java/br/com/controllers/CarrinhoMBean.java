package br.com.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.models.Prato;
import br.com.services.CarrinhoService;

@Controller
@Scope("request")
public class CarrinhoMBean {
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	private Map<Prato, Integer> pratos;
	
	@PostConstruct
	public void init() {
		this.setPratos(carrinhoService.getPratos());
	}
	
	public Map<Prato, Integer> getPratos() {
		return pratos;
	}

	public void setPratos(HashMap<Prato, Integer> pratos) {
		this.pratos = pratos;
	}
	
	public void adicionar(Prato prato) {
		carrinhoService.adicionarPratos(prato, 1);
		this.setPratos(carrinhoService.getPratos());
	}
	
	public void excluir(Prato prato) {
		carrinhoService.excluirPrato(prato);
		this.setPratos(carrinhoService.getPratos());
	}
	
	public List<Prato> getKeyAsList(){
	     return new ArrayList<Prato>(pratos.keySet());
	}

}

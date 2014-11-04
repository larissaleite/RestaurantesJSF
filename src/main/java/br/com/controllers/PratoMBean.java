package br.com.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.models.Cliente;
import br.com.models.Prato;
import br.com.services.CarrinhoService;
import br.com.services.RestauranteService;

@Controller
@Scope("request")
public class PratoMBean {
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private RestauranteService restauranteService;
	
	private List<Prato> pratos;
	
	private List<Prato> pratosRecomendados;
	
	private Cliente cliente;
	
	@PostConstruct
	public void init() {
		this.setPratos(restauranteService.getPratos());
		if (pratosRecomendados == null)
			pratosRecomendados = restauranteService.getPratosRecomendados(getCliente());
		System.out.println(pratosRecomendados.size());
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	
	public List<Prato> getPratosRecomendados() {
		return pratosRecomendados;
	}

	public void setPratosRecomendados(List<Prato> pratosRecomendados) {
		this.pratosRecomendados = pratosRecomendados;
	}

	public void adicionar(Prato prato) {
		System.out.println("quant "+prato.getQuantidade());
		carrinhoService.adicionarPratos(prato, prato.getQuantidade());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Adicionado "+prato.getNome()+" com sucesso"));
	}
	
	public List<String> getQuantidades() {
        List<String> quantidades = new ArrayList<String>();
        quantidades.add("1");
        quantidades.add("2");
        quantidades.add("3");
        return quantidades;
    }

	public Cliente getCliente() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = (HttpSession) request.getSession();
		String emailUsuario = session.getAttribute("usuario_email").toString();
		
		this.cliente = restauranteService.getCliente(emailUsuario);
		
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}

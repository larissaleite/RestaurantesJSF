package br.com.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.models.Cartao.Tipo;
import br.com.models.Cliente;
import br.com.models.Pagamento;
import br.com.models.Pedido;
import br.com.models.PedidoItem;
import br.com.models.Prato;
import br.com.services.CarrinhoService;
import br.com.services.PagamentoService;
import br.com.services.RestauranteService;

@Controller
@ViewScoped //ViewScoped necessário por conta do h:commandButton com rendered
public class PedidoMBean {
	
	@Autowired
	protected RestauranteService restauranteService;
	
	@Autowired
	protected PagamentoService pagamentoService;
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	private Map<Prato, Integer> pratos;
	
	protected Cliente cliente;
	
	private List<Tipo> cartoesTipos;
	
	private String tipoPagamento;
	
	protected float total;
	 
    public List<Tipo> getCartoesTipos() {
        return Arrays.asList(Tipo.values());
    }
    
    public void setCartoesTipos(List<Tipo> cartoesTipos) {
    	this.cartoesTipos = cartoesTipos;
    }
	
	@PostConstruct
	public void init() {
		this.setPratos(carrinhoService.getPratos());
		this.setTipoPagamento("cartao");
		this.setTotal(10);
	}
	
	public Map<Prato, Integer> getPratos() {
		return pratos;
	}

	public void setPratos(HashMap<Prato, Integer> pratos) {
		this.pratos = pratos;
	}
	
	public List<Prato> getKeyAsList(){
	     return new ArrayList<Prato>(pratos.keySet());
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

	public String confirmarPedido(Pagamento pagamento) {
		
		restauranteService.cadastrarPagamento(pagamento);
		
		Pedido pedido = new Pedido();
		pedido.setPagamento(pagamento);
		pedido.setCliente(getCliente());
		pedido.setData(new Date(new java.util.Date().getTime()));
		
		int precoTotal = 0;
		
		List<PedidoItem> pratos = new ArrayList<PedidoItem>();
		for (Prato p : this.pratos.keySet()) {
			PedidoItem pedidoItem = new PedidoItem();
			pedidoItem.setPrato(p);
			pedidoItem.setQuantidade(this.pratos.get(p));
			precoTotal += p.getPreco()*pedidoItem.getQuantidade();
			pratos.add(pedidoItem);
		}
		
		pedido.setPratos(pratos);
		pedido.setTotal(precoTotal);
		
		restauranteService.cadastrarPedido(pedido);
		
		carrinhoService.limparCarrinho();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido confirmado! Obrigada, em breve ele será entregue em sua casa!"));
		
		/*HttpSession session = ((HttpServletRequest) (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession();
		session.invalidate();*/
		
		return "login.jsf";
	}
	
	public String cancelarPedido() {
		
		carrinhoService.limparCarrinho();
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);		
		
		facesContext.addMessage(null, new FacesMessage("Pedido cancelado, até a próxima!"));
		
		HttpSession session = ((HttpServletRequest) (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession();
		session.invalidate();
		
		return "login.jsf";
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}

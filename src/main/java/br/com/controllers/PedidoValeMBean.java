package br.com.controllers;

import org.springframework.stereotype.Controller;

import br.com.models.Pagamento;
import br.com.models.ValeAlimentacao;

@Controller
public class PedidoValeMBean extends PedidoMBean {
	
	private ValeAlimentacao valeAlimentacao;
	
	public PedidoValeMBean() {
		valeAlimentacao = new ValeAlimentacao();
	}
	
	public ValeAlimentacao getValeAlimentacao() {
		return valeAlimentacao;
	}

	public void setValeAlimentacao(ValeAlimentacao valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}

	public void confirmarPagamento() {
		this.pagamentoService.pagamentoValeAlimentacao(total, valeAlimentacao.getNumero(), valeAlimentacao.getNome());
		this.restauranteService.cadastrarValeAlimentacao(valeAlimentacao);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setValeAlimentacao(valeAlimentacao);
		
		super.confirmarPedido(pagamento);
		
	}
	
}

package br.com.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.models.Cartao.Tipo;

@Service("pagamentoService")
public class PagamentoService {
	
	private PagamentoStrategy pagamentoStrategy;
	
	public void pagamentoCartao (float valor, String nome, String numero, Date dataVencimento, int codigoSeguranca, Tipo tipo) {
		pagamentoStrategy = new PagamentoCartao(nome, numero, dataVencimento, codigoSeguranca, tipo);
		pagamentoStrategy.pagar(valor);
	}
	
	public void pagamentoPayPal(float valor, String login, String senha) {
		pagamentoStrategy = new PagamentoPayPal(login, senha);
		pagamentoStrategy.pagar(valor);
	}
	
	public void pagamentoValeAlimentacao(float valor, String numero, String nome) {
		pagamentoStrategy = new PagamentoValeAlimentacao(numero, nome);
		pagamentoStrategy.pagar(valor);
	}
	
}

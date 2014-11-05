package br.com.services;

import java.util.Date;

import br.com.models.Cartao.Tipo;

public class PagamentoCartao implements PagamentoStrategy {
	
	private String nome;
	private String numero;
	private Date dataVencimento;
	private int codigoSeguranca;
	private Tipo tipo;
	
	public PagamentoCartao (String nome, String numero, Date dataVencimento, int codigoSeguranca, Tipo tipo) {
		this.nome = nome;
		this.numero = numero;
		this.dataVencimento = dataVencimento;
		this.codigoSeguranca = codigoSeguranca;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void pagar(float valor) {
		System.out.println("pagamento cartao");
	}

}

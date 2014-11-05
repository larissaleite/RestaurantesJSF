package br.com.services;

public class PagamentoValeAlimentacao implements PagamentoStrategy {
	
	private String numero;
	private String nome;
	
	public PagamentoValeAlimentacao(String numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void pagar(float valor) {
		System.out.println("pagamento vale");
	}

}

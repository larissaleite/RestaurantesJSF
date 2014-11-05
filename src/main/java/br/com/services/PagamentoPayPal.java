package br.com.services;

public class PagamentoPayPal implements PagamentoStrategy {
	
	private String login;
	private String senha;
	
	public PagamentoPayPal (String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void pagar(float valor) {
		System.out.println("pagamento paypal");
		
	}

}

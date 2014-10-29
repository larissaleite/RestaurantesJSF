package br.com.controllers;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.models.Cliente;
import br.com.services.RestauranteService;

@Controller
public class ClienteMBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private RestauranteService restauranteService;
	
	private String nome;
	private String email;
	private String senha;
	private String endereco;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String cadastrar() {
		Cliente cliente = new Cliente();
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		cliente.setNome(nome);
		cliente.setSenha(senha);
		cliente.setTelefone(telefone);
		
		System.out.println("cadastrando "+cliente.getEmail());
		
		restauranteService.cadastrarCliente(cliente);
		
		return "login.jsf";
	}
	
	public String autenticar() {
		Cliente cliente = new Cliente();
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		if (restauranteService.autenticar(cliente)) {
			
			HttpSession session = ((HttpServletRequest) (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession();
			session.setAttribute("usuario_email", cliente.getEmail());
			
			return "pratos.jsf";
		} else {
			return "login.jsf";
		}
	}

}

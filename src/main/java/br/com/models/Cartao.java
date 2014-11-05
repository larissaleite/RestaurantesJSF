package br.com.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Tipo {
		VISA, MASTER, MAESTRO;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_cartao", unique=true, nullable=false)
	private int id;
	@Column(name="nome", nullable=false)
	private String nome;
	@Column(name="numero", nullable=false)
	private String numero;
	@Column(name="data_vencimento", nullable=false)
	private Date dataVencimento;
	@Column(name="codigo_seguranca", nullable=false)
	private int codigoSeguranca;
	@Column(name="tipo", nullable=false)
	private Tipo tipo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}

package br.com.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Promocao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_promocao", unique=true, nullable=false)
	private int id;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prato_id")
	private Prato prato;
	@Column(name="dia", nullable=false)
	private int dia;
	@Column(name="preco", nullable=false)
	private float preco;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Prato getPrato() {
		return prato;
	}
	
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}

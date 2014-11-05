package br.com.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_pagamento", unique=true, nullable=false)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cartao_id")
	private Cartao cartao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="paypal_id")
	private PayPal payPal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="vale_id")
	private ValeAlimentacao valeAlimentacao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public PayPal getPayPal() {
		return payPal;
	}

	public void setPayPal(PayPal payPal) {
		this.payPal = payPal;
	}

	public ValeAlimentacao getValeAlimentacao() {
		return valeAlimentacao;
	}

	public void setValeAlimentacao(ValeAlimentacao valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}
	
}

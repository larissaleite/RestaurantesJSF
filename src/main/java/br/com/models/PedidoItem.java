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
import javax.persistence.OneToOne;

@Entity
public class PedidoItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_pedido_item", unique=true, nullable=false)
	private int id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prato_id")
	private Prato prato;
	
	@Column(name="quantidade", nullable=false)
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}

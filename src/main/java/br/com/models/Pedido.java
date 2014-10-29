package br.com.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_pedido", unique=true, nullable=false)
	private int id;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="pedido_id")
	private List<PedidoItem> pratos;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
	private Cliente cliente;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cartao")
	private Cartao cartao;
    
    @Column(name="total", nullable=false)
    private float total;
    
    @Column(name="data", nullable=false)
    private Date data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<PedidoItem> getPratos() {
		return pratos;
	}
	
	public void setPratos(List<PedidoItem> pratos) {
		this.pratos = pratos;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cartao getCartao() {
		return cartao;
	}
	
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}

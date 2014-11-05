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
import javax.persistence.OneToOne;

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

    @Column(name="total", nullable=false)
    private float total;
    
    @Column(name="data", nullable=false)
    private Date data;
    
    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pagamento_id")
	private Pagamento pagamento;

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

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
}

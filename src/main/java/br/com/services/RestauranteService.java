package br.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.interfaces.IDaoCartao;
import br.com.dao.interfaces.IDaoCliente;
import br.com.dao.interfaces.IDaoPagamento;
import br.com.dao.interfaces.IDaoPayPal;
import br.com.dao.interfaces.IDaoPedido;
import br.com.dao.interfaces.IDaoPrato;
import br.com.dao.interfaces.IDaoPromocao;
import br.com.dao.interfaces.IDaoValeAlimentacao;
import br.com.models.Cartao;
import br.com.models.Cliente;
import br.com.models.Pagamento;
import br.com.models.PayPal;
import br.com.models.Pedido;
import br.com.models.Prato;
import br.com.models.ValeAlimentacao;

@Service("restauranteService")
public class RestauranteService {
	
	@Autowired
	private IDaoCliente daoCliente;
	
	@Autowired
	private IDaoPrato daoPrato;
	
	@Autowired
	private IDaoCartao daoCartao;
	
	@Autowired
	private IDaoPedido daoPedido;
	
	@Autowired
	private IDaoPromocao daoPromocao;
	
	@Autowired
	private IDaoPagamento daoPagamento;
	
	@Autowired
	private IDaoValeAlimentacao daoValeAlimentacao;
	
	@Autowired
	private IDaoPayPal daoPayPal;
	
	@Autowired
	private RecomendacaoService recomendacaoService;
	
	public void cadastrarCliente(Cliente cliente) {
		daoCliente.cadastrar(cliente);
	}
	
	public boolean autenticar(Cliente cliente) {
		return daoCliente.autenticar(cliente.getEmail(), cliente.getSenha());
	}
	
	public List<Prato> getPratos() {
		return daoPrato.getPratos();
	}
	
	public Cliente getCliente(String email) {
		return daoCliente.getCliente(email);
	}
	
	public void cadastrarCartao(Cartao cartao) {
		daoCartao.cadastrar(cartao);
	}
	
	public void cadastrarPagamento(Pagamento pagamento) {
		daoPagamento.cadastrar(pagamento);
	}
	
	public void cadastrarPayPal(PayPal payPal) {
		daoPayPal.cadastrar(payPal);
	}
	
	public void cadastrarValeAlimentacao(ValeAlimentacao valeAlimentacao) {
		daoValeAlimentacao.cadastrar(valeAlimentacao);
	}
	
	public void cadastrarPedido(Pedido pedido) {
		daoPedido.cadastrar(pedido);
	}
	
	public List<Prato> getPratosRecomendados(Cliente cliente) {
		return recomendacaoService.getPratosRecomendados(cliente);
	}
	
	public List<Prato> getPromocoes(int diaDaSemana) {
		List<Prato> listaPratos = daoPromocao.getPromocaoDia(diaDaSemana);
		for (Prato prato : listaPratos) {
			Prato p = daoPrato.getPrato(prato.getId());
			prato.setImagem(p.getImagem());
			prato.setIngredientes(p.getIngredientes());
			prato.setNome(p.getNome());
		}
		return listaPratos;
	}
	
	public List<Prato> getPratosCliente(Cliente cliente) {
		return daoPrato.getPratosCliente(cliente);
	}
	
	public List<Prato> getTodosPedidos() {
		return daoPrato.getPratosPorPedido();
	}
	
}

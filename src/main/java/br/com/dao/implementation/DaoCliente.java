package br.com.dao.implementation;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoCliente;
import br.com.models.Cliente;

@Repository
@Transactional
public class DaoCliente extends AbstractHibernateDao<Cliente> implements IDaoCliente {
	
	public DaoCliente() {
		super();
		super.setClasse(Cliente.class);
	}

	public void cadastrar(Cliente cliente) {
		super.save(cliente);
	}

	public boolean autenticar(String email, String senha) {
		@SuppressWarnings("rawtypes")
		List cliente = super.hqlQuery("SELECT * from cliente WHERE email = '"+email+"' AND senha='"+senha+"'");
		
		if (cliente.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public Cliente getCliente(String email) {
		List cliente = super.hqlQuery("SELECT * from cliente WHERE email = '"+email+"'");
		
		if (cliente.size() > 0) {
			Cliente c = new Cliente();
			Map clienteMap = (Map) cliente.get(0);
			c.setId(Integer.parseInt(clienteMap.get("id_cliente").toString()));
			c.setEmail(clienteMap.get("email").toString());
			c.setEndereco(clienteMap.get("endereco").toString());
			c.setNome(clienteMap.get("nome").toString());
			c.setTelefone(clienteMap.get("telefone").toString());
			
			return c;
		} else {
			return null;
		}
	}

}

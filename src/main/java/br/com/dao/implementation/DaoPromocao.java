package br.com.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoPromocao;
import br.com.models.Prato;
import br.com.models.Promocao;

@Repository
@Transactional
public class DaoPromocao extends AbstractHibernateDao<Promocao> implements IDaoPromocao {

	public DaoPromocao() {
		super();
		super.setClasse(Promocao.class);
	}

	@SuppressWarnings("rawtypes")
	public List<Prato> getPromocaoDia(int dia) {
		List promocao = super.hqlQuery("SELECT * from promocao WHERE dia = "+dia+";");
		
		List<Prato> listaPratos = new ArrayList<Prato>();
		
		if (promocao.size() > 0) {
			Prato p = new Prato();
			Map promocaoMap = (Map) promocao.get(0);

			p.setId(Integer.parseInt(promocaoMap.get("prato_id").toString()));
			p.setPreco(Float.parseFloat(promocaoMap.get("preco").toString()));
			
			listaPratos.add(p);
		}
		
		return listaPratos;
	}
	
}

package br.com.dao.interfaces;

import java.util.List;

import br.com.models.Prato;
import br.com.models.Promocao;

public interface IDaoPromocao {
	
	public List<Prato> getPromocaoDia(int dia);

}

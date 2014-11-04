package br.com.dao.interfaces;

import java.util.List;

import br.com.models.Prato;

public interface IDaoPromocao {
	
	public List<Prato> getPromocaoDia(int dia);

}

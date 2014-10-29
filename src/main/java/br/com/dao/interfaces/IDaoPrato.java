package br.com.dao.interfaces;

import java.util.List;

import br.com.models.Prato;

public interface IDaoPrato {
	public void cadastrar (Prato prato);
	public List<Prato> getPratos();
}

package br.com.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.models.Cliente;
import br.com.models.Prato;

public class RecomendadorData extends Recomendador {

	@Override
	public List<Prato> recomendar(List<Prato> pratos, Cliente cliente) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int diaDaSemana = c.get(Calendar.DAY_OF_WEEK);
		
		List<Prato> pratosPromocoes = this.restauranteService.getPromocoes(diaDaSemana);
		
		for (Prato prato : pratosPromocoes) {
			pratos.add(prato);
		}
		
		if (this.sucessor != null) {
			return sucessor.recomendar(pratos, cliente);
		}
		
		return pratos;
	}

}

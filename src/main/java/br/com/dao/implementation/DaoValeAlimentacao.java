package br.com.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.interfaces.IDaoValeAlimentacao;
import br.com.models.ValeAlimentacao;

@Repository
@Transactional
public class DaoValeAlimentacao extends AbstractHibernateDao<ValeAlimentacao> implements IDaoValeAlimentacao {

	public DaoValeAlimentacao() {
		super();
		super.setClasse(ValeAlimentacao.class);
	}

	public void cadastrar(ValeAlimentacao valeAlimentacao) {
		super.save(valeAlimentacao);
	}
}

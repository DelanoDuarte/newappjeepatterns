/**
 * 
 */
package br.com.appjee.businessimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.appjee.business.GratificacaoBusiness;
import br.com.appjee.dao.GratificacaoDAO;
import br.com.appjee.domain.Gratificacao;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class GratificacaoBusinessImpl implements GratificacaoBusiness {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private GratificacaoDAO gratificacaoDAO;

	@Override
	public Gratificacao salvar(Gratificacao gratificacao) {
		return gratificacaoDAO.update(gratificacao);
	}

	@Override
	public List<Gratificacao> buscarTodas() {
		return gratificacaoDAO.findAll();
	}

	@Override
	public Gratificacao buscaPorId(Long id) {
		return gratificacaoDAO.findById(id);
	}

}

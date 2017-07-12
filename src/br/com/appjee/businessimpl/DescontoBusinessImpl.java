/**
 * 
 */
package br.com.appjee.businessimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.appjee.business.DescontoBusiness;
import br.com.appjee.dao.DescontoDAO;
import br.com.appjee.domain.Desconto;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class DescontoBusinessImpl implements DescontoBusiness {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private DescontoDAO descontoDAO;

	@Override
	public Desconto salvar(Desconto desconto) {
		return descontoDAO.update(desconto);
	}

	@Override
	public List<Desconto> buscarTodos() {
		return descontoDAO.findAll();
	}

	@Override
	public Desconto buscaPorId(Long id) {
		return descontoDAO.findById(id);
	}

}

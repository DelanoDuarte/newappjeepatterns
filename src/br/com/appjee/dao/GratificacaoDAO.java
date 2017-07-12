/**
 * 
 */
package br.com.appjee.dao;

import javax.enterprise.context.RequestScoped;

import br.com.appjee.domain.Gratificacao;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class GratificacaoDAO extends AbstractDAO<Gratificacao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GratificacaoDAO() {
		super(Gratificacao.class);
	}

}

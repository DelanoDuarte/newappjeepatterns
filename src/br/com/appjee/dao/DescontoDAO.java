/**
 * 
 */
package br.com.appjee.dao;

import javax.enterprise.context.RequestScoped;

import br.com.appjee.domain.Desconto;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class DescontoDAO extends AbstractDAO<Desconto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DescontoDAO() {
		super(Desconto.class);
	}
}

/**
 * 
 */
package br.com.appjee.dao;

import javax.enterprise.context.RequestScoped;

import br.com.appjee.domain.Funcionario;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class FuncionarioDAO extends AbstractDAO<Funcionario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FuncionarioDAO() {
		super(Funcionario.class);
	}

	public Funcionario buscarPorId(Long id) {
		try {
			Funcionario funcionario = (Funcionario) entityManager
					.createQuery("select f from Funcionario f join fetch f.gratificacoes where f.id = :id")
					.setParameter("id", id).getSingleResult();
			return funcionario;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 */

}

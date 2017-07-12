/**
 * 
 */
package br.com.appjee.dao;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;

import br.com.appjee.domain.User;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class UserDAO extends AbstractDAO<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDAO() {
		super(User.class);
	}

	public User findUserByLogin(String login) {
		try {
			return entityManager.createQuery("select n from User n where n.login like :plogin", User.class)
					.setParameter("plogin", login).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}

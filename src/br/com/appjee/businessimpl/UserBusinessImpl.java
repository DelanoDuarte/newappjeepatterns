/**
 * 
 */
package br.com.appjee.businessimpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.appjee.business.UserBusiness;
import br.com.appjee.dao.UserDAO;
import br.com.appjee.domain.User;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class UserBusinessImpl implements UserBusiness {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UserDAO userDAO;

	@Override
	public User salvar(User user) {
		return userDAO.update(user);
	}

	@Override
	public User findById(Long id) {
		return userDAO.findById(id);
	}

	@Override
	public User findUserByLogin(String login) {
		return userDAO.findUserByLogin(login);
	}

}

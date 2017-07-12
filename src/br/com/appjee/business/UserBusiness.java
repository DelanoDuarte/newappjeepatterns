/**
 * 
 */
package br.com.appjee.business;

import java.io.Serializable;

import br.com.appjee.domain.User;

/**
 * @author delano.duarte
 *
 */
public interface UserBusiness extends Serializable {

	public User salvar(User user);

	public User findById(Long id);

	public User findUserByLogin(String login);
}

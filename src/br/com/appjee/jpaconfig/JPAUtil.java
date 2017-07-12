package br.com.appjee.jpaconfig;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("appjee");
		return emf;
	}

	public static EntityManager getEntityManager() {
		if (em != null && em.isOpen())
			return em;
		else {
			em = getEntityManagerFactory().createEntityManager();
			return em;
		}
	}
}
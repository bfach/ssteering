package com.bfc.sobersteering.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bfc.sobersteering.bean.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext private EntityManager em;

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(User user) {
		em.persist(user);
		em.flush();
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public User findUserByName(String userName) {
		User result = null;
		try {
			TypedQuery<User> query = em.createQuery("select u from User u where u.username = ?", User.class);
			query.setParameter(1, userName);
			result = query.getSingleResult();
		} catch (NoResultException e) {
		// no role found with the given role name
		}
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(User user) {
		try {
			Query query = em.createQuery("delete from User u where u.username = ?");
			query.setParameter(1, user.getUsername());
			query.executeUpdate();
		} catch (NoResultException e) {
		// no role found with the given role name
		}
	}

	public int retrieveUserId(String username) {
		final User user = findUserByName(username);

		if (user == null) {
			throw new IllegalArgumentException("User not registered "
					+ username);
		}
		return user.getId();
	}

}
package com.pool.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pool.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	SessionFactory sessionFactory;

	public User findUserByUserName(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select u from User u where u.email=:email");
		query.setParameter("email", email);
		return (User) query.uniqueResult();
	}
}

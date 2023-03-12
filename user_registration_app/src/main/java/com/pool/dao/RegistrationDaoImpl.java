package com.pool.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pool.model.Registration;

@Service
public class RegistrationDaoImpl implements RegistrationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Integer saveUser(Registration registration) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(registration);
	}

	public List<Registration> usersList() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("====================Creteria-START==================");
		Criteria criteria=session.createCriteria(Registration.class);
		criteria.setFetchMode("roles", FetchMode.EAGER);
		criteria.list();
		System.out.println("====================Creteria-END==================");
		System.out.println("====================JoinFetch-START==================");
		Query queryJoinFetch = session.createQuery("FROM Registration r join fetch r.roles Role", Registration.class);
		queryJoinFetch.getResultList();
		System.out.println("====================JoinFetch-END==================");
		System.out.println("====================N+1-START==================");
		Query query = session.createQuery("FROM Registration", Registration.class);
		List<Registration> userlist=query.getResultList();
		System.out.println("====================N+1-END==================");
		return userlist;
		
	}

	public void updateUser(Registration registration) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(registration);
		;
	}

	public Integer deleteUser(Integer userid) {
		Session session = sessionFactory.getCurrentSession();
		Registration registration = session.get(Registration.class, userid);
		if (registration != null) {
			session.delete(registration);
		}
		return userid;
	}

	public Registration getUserByEmailAndPassword(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT R FROM Registration R where R.email=:email AND R.password=:password");
		query.setParameter("email", username);
		query.setParameter("password", password);
		return (Registration) query.uniqueResult();
	}

	public Registration getUserByUserId(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		Registration registration=session.get(Registration.class, userId);
		return registration;
	}

	public Long isUserExist(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select count(*) from Registration r where r.email=:email");
		query.setParameter("email", email);
		return (Long) query.uniqueResult();
	}

}

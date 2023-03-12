package com.pool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pool.model.CachePerson;
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
		Query query = session.createQuery("FROM Registration", Registration.class);
		return query.getResultList();
	}

	public void updateUser(Registration registration) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(registration);
		;
	}

	public Integer deleteUser(Integer userid) {
		Session session = sessionFactory.getCurrentSession();
		Registration registration = session.get(Registration.class, userid);
		int deleteid=0;
		if (registration != null) {
			deleteid=registration.getUserId();
			session.delete(registration);
		}
		return deleteid;
	}

	public Registration getUserByEmailAndPassword(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT R FROM Registration R where R.email=:email AND R.password=password");
		query.setParameter("email", username);
		query.setParameter("password", password);
		return (Registration) query.uniqueResult();
	}

	public Registration getUserByUserId(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		Registration registration=session.get(Registration.class, userId);
		return registration;
	}

	public List<CachePerson> getAllCachePersons() {
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createNamedQuery("GET_ALL_PERSONS",CachePerson.class);
		return query.getResultList();
	}

}

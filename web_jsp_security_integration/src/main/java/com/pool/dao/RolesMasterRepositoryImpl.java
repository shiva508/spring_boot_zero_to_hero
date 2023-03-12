package com.pool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.pool.model.RolesMaster;
@Repository
public class RolesMasterRepositoryImpl implements RolesMasterRepository {
	@Autowired
	private SessionFactory sessionFactory;
	@Cacheable(value="rolesMasterCache")
	public List<RolesMaster> getAllRoles() {
		Session session=sessionFactory.getCurrentSession(); 
		Query query=session.createQuery("from RolesMaster",RolesMaster.class);
		return query.getResultList();
	}

}

package com.pool.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pool.model.onetoone.AccountEntity;
import com.pool.model.onetoone.EmployeeEntity;

@Repository
public class EmployeeEntityDaoImpl implements EmployeeEntityDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Integer saveAccount(AccountEntity accountEntity) {
		Session session=sessionFactory.getCurrentSession();
		return (Integer) session.save(accountEntity);
	}

	public Integer saveEmploye(EmployeeEntity employeeEntity) {
		Session session=sessionFactory.getCurrentSession();
		return (Integer) session.save(employeeEntity);
	}

	public List<EmployeeEntity> employeeEntities() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from EmployeeEntity",EmployeeEntity.class);
		return query.getResultList();
	}

}

package com.pool.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pool.model.Department;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
	@Autowired
	private SessionFactory sessionFactory;

	public Department finfDepartmentById(Integer departmentId) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("from Department").setCacheable(true).setCacheRegion("");
		return null;
	}

	public List<Department> findDepartmentByStoredProcedureUsingcreateSQLQuery() {
		/* Native SQL � createSQLQuery */
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("CALL GETALLROLES()").addEntity(Department.class);
		return query.getResultList();
	}

	public List<Department> findDepartmentByStoredProcedureUsinggetNamedQuery() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("GETALLDEPOTS");
		return query.getResultList();
	}
	public void queriesUsingCriteriaBuilder() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery criteriaQuery= (CriteriaQuery) builder.createQuery(Department.class);
	}

}

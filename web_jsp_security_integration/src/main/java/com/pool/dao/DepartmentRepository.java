package com.pool.dao;

import java.util.List;

import com.pool.model.Department;

public interface DepartmentRepository {
public Department finfDepartmentById(Integer departmentId);
public List<Department> findDepartmentByStoredProcedureUsingcreateSQLQuery();
public List<Department> findDepartmentByStoredProcedureUsinggetNamedQuery();
}

package com.pool.dao;

import java.util.List;

import com.pool.model.onetoone.AccountEntity;
import com.pool.model.onetoone.EmployeeEntity;

public interface EmployeeEntityDao {
public Integer saveAccount(AccountEntity accountEntity);
public Integer saveEmploye(EmployeeEntity employeeEntity);
public List<EmployeeEntity> employeeEntities();

}

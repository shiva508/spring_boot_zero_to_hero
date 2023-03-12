package com.pool.service;

import java.util.List;

import com.pool.model.onetoone.AccountEntity;
import com.pool.model.onetoone.EmployeeEntity;

public interface EmployeeEntityService {
	public Integer saveAccount(AccountEntity accountEntity);
	public Integer saveEmploye(EmployeeEntity employeeEntity);
	public List<EmployeeEntity> employeeEntities();
}

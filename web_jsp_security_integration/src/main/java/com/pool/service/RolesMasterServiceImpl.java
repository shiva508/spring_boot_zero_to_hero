package com.pool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pool.dao.RolesMasterRepository;
import com.pool.model.RolesMaster;

@Service
public class RolesMasterServiceImpl implements RolesMasterService {
	@Autowired
	private RolesMasterRepository rolesMasterRepository;
	@Transactional
	public List<RolesMaster> getAllRoles() {
		return rolesMasterRepository.getAllRoles();
	}
}

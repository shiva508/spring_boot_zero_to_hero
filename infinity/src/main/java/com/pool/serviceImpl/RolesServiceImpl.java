package com.infinity.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infinity.dao.RolesRepository;
import com.infinity.model.Role;
import com.infinity.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {
	@Autowired
	RolesRepository rolesRepository;
	@Transactional()
	public Role save(Role role) {
		return rolesRepository.save(role);
	}
	@Transactional(readOnly=true)
	public List<Role> roles() {
		return rolesRepository.findAll();
	}
}

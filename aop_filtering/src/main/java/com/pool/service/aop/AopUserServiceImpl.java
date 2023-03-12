package com.pool.service.aop;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.pool.model.aop.AopUser;
import com.pool.repository.aop.AopUserRepository;
import com.pool.util.exception.AopUserNotFound;

@Service
public class AopUserServiceImpl implements AopUserService {

	@Autowired
	private AopUserRepository aopUserRepository;

	@Override
	@Transactional
	public AopUser save(AopUser aopUser) {
		return aopUserRepository.save(aopUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public AopUser getAopUserByUserId(Integer userId) {
		Optional<AopUser> aopUser = aopUserRepository.findById(userId);
		if (aopUser.isPresent()) {
			return aopUser.get();
		} else {
			throw new AopUserNotFound("Data Not Found");
		}
	}

	@Override
	@Transactional
	public List<AopUser> getAllAopUsers() {
		List<AopUser> aopUsers = aopUserRepository.findAll();
		if (null == aopUsers || aopUsers.size() > 0) {
			return aopUsers;
		} else {
			throw new AopUserNotFound("Data Not Found");
		}
	}

	@Override
	public void called() {
		System.out.println("have fun");
		
	}
	
	@Override
	public void setUserName(String userName) {
		System.out.println("userName:" + userName);
	}

	@Override
	public String getUserName() {

		return "SHIVA";
	}

	@Override
	public void setPassword(String password) {
		System.out.println("password:" + password);
	}

	@Override
	public String getPassword() {
		return "SHIVA PASSWORD";
	}

}

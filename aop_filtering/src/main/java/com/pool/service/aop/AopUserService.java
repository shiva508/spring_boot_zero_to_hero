package com.pool.service.aop;

import java.util.List;

import com.pool.model.aop.AopUser;

public interface AopUserService {
	public AopUser save(AopUser aopUser);

	public AopUser getAopUserByUserId(Integer userId);

	public List<AopUser> getAllAopUsers();

	public void called();

	public void setUserName(String userName);

	public String getUserName();

	public void setPassword(String password);

	public String getPassword();
}

package com.pool.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
//@Profile("devl")
public class DevlProfileService implements ProfileService{
	@Value("db.driver")
	private String code;
	
	@Override
	public void executeTask() {
		System.out.println(this.code);
	}
}

package com.pool.serviceImpl;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pool.dao.UsersRepository;
import com.pool.form.CustomUserDetails;
import com.pool.model.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	/*@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users>optionalUsers=userRepository.findByName(username);
		optionalUsers.orElseThrow(()->new UsernameNotFoundException("USER NAME NOT FOUND"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}*/
}

package com.pool.serviceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pool.dao.UsersRepository;
import com.pool.form.AddressForm;
import com.pool.form.UserForm;
import com.pool.model.Address;
import com.pool.model.Users;
import com.pool.service.UserService;

import ma.glasnost.orika.MapperFacade;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private MapperFacade formDomainMapperFacade;
	@Autowired
	private UsersRepository userRepository;

	@Override
	@Transactional
	public UserForm saveUser(UserForm userForm) {
	/*	System.out.println(userForm);
		Users user = formDomainMapperFacade.map(userForm, Users.class);
		populateFormToDomine(userForm, user);
		Users usersaved =userRepository.save(user);
		UserForm userFormSaved=formDomainMapperFacade.map(usersaved, UserForm.class);*/
		return null;
	}

	@Override
	@Transactional
	public UserForm getUser(Integer userId) {
		/*Optional<Users> user=userRepository.findById(userId);
		UserForm userForm=null;
		if (user.isPresent()) {
			Users userRepo=user.get();
			userForm=formDomainMapperFacade.map(userRepo, UserForm.class);	
		}*/
		return null;
	}

	public void populateFormToDomine(UserForm userforn, Users user) {
		if (userforn.getAddressForm() != null) {
			for(AddressForm addressForm:userforn.getAddressForm()) {
				Address address= formDomainMapperFacade.map(addressForm, Address.class);
			}
		}
	}
}

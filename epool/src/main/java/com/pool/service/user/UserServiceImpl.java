package com.pool.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pool.entity.UserEntity;
import com.pool.model.CommonResponseModel;
import com.pool.model.UserModel;
import com.pool.model.exception.NoRecardsFoundException;
import com.pool.repository.UserRepository;
import com.pool.util.EpoolConstants;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserModel saveUser(UserModel userModel) {
		return null;
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		return null;
	}

	@Override
	public CommonResponseModel deleteUser(Long userId) {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
		CommonResponseModel commonResponseModel=new CommonResponseModel();
		optionalUserEntity.ifPresentOrElse((data)->{
			userRepository.delete(optionalUserEntity.get());
			commonResponseModel.setMessage(EpoolConstants.DELETE_MESSAGE).setStatusCode(HttpStatus.OK.value());
		}, ()->{
			throw new NoRecardsFoundException(EpoolConstants.USER_NOT_FOUNT);
		});
		
		if (optionalUserEntity.isPresent()) {
			userRepository.delete(optionalUserEntity.get());
			return new CommonResponseModel().setMessage(EpoolConstants.DELETE_MESSAGE).setStatusCode(HttpStatus.OK.value());
		} else {
			throw new NoRecardsFoundException(EpoolConstants.USER_NOT_FOUNT);
		}
	}

	@Override
	public UserModel userByUserId(Long userId) {

		return null;
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {

		return userRepository.save(userEntity);
		
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {

		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity userByUserEntityId(Long userId) {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
		if (optionalUserEntity.isPresent()) {
			return optionalUserEntity.get();
		} else {
			throw new NoRecardsFoundException(EpoolConstants.USER_NOT_FOUNT);
		}

	}

}

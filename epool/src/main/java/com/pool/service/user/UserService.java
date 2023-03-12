package com.pool.service.user;

import com.pool.entity.UserEntity;
import com.pool.model.CommonResponseModel;
import com.pool.model.UserModel;

public interface UserService {
	public UserModel saveUser(UserModel userModel);

	public UserModel updateUser(UserModel userModel);

	public CommonResponseModel deleteUser(Long userId);

	public UserModel userByUserId(Long userId);

	public UserEntity saveUser(UserEntity userEntity);

	public UserEntity updateUser(UserEntity userEntity);

	public UserEntity userByUserEntityId(Long userId);

}

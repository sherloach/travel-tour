package com.nqhtour.service.impl;

import com.nqhtour.constant.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nqhtour.converter.UserConverter;
import com.nqhtour.dto.UserDTO;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;
	
	@Override
	public UserDTO findById(long id) {
		
		return null;
	}

	@Override
	public Long save(UserDTO dto) {
		UserEntity userEntity = userConverter.toEntity(dto);
		
		return userRepository.save(userEntity).getId();
	}

	@Override
	public void delete(long id) {
		
	}

	@Override
	public boolean checkAccount(String username, String password) {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if (userEntity != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			boolean isPasswordMatches = encoder.matches(password, userEntity.getPassword());
			if (isPasswordMatches) {
				return true;
			}
		}
		return false;
	}
}

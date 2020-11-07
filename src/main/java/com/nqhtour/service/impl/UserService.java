package com.nqhtour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		return userConverter.toDTO(userRepository.save(userEntity)).getId();
	}

	@Override
	public void delete(long id) {
		
	}

}

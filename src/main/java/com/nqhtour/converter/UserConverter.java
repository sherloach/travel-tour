package com.nqhtour.converter;

import org.springframework.stereotype.Component;

import com.nqhtour.dto.UserDTO;
import com.nqhtour.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toDTO(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setUsername(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setRole(entity.getRole());
		result.setStatus(entity.getStatus());
		
		return result;
	}

	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUsername());
		result.setPassword(dto.getPassword());
		result.setRole(dto.getRole());
		result.setStatus(dto.getStatus());
		
		return result;
	}
	
}

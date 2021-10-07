package com.nqhtour.service.impl;

import com.nqhtour.constant.SystemConstant;
import com.nqhtour.converter.EmployeeConverter;
import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nqhtour.converter.UserConverter;
import com.nqhtour.dto.UserDTO;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IUserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;

	@Autowired
	EmployeeConverter employeeConverter;

	@Override
	public UserDTO findById(long id) {
		
		return null;
	}

	// Get all guides in database
	@Override
	public List<EmployeeDTO> findAllByRole(String role) {
		List<EmployeeDTO> listGuide = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAllByRole(role);
		for (UserEntity user : entities) {
			listGuide.add(employeeConverter.toDTO(user.getEmployee().get(0)));
		}

		return listGuide;
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

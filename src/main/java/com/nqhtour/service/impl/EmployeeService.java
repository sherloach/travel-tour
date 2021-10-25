package com.nqhtour.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nqhtour.constant.SystemConstant;
import com.nqhtour.converter.EmployeeConverter;
import com.nqhtour.converter.UserConverter;
import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.dto.UserDTO;
import com.nqhtour.entity.EmployeeEntity;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.EmployeeRepository;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IEmployeeService;
import com.nqhtour.util.UploadFileUtil;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeConverter employeeConverter;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;

	@Autowired
	PasswordEncoder passwordEncode;

	@Autowired
	private UploadFileUtil uploadFileUtil;
	
	@Autowired
	private ServletContext context;

	@Override
	public List<EmployeeDTO> findAll(Pageable pageable) {
		List<EmployeeDTO> models = new ArrayList<>();
		List<EmployeeEntity> entities = employeeRepository.findAll(pageable).getContent();
		for (EmployeeEntity item : entities) {
			EmployeeDTO emplDTO = employeeConverter.toDTO(item);
			models.add(emplDTO);
		}
		
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) employeeRepository.count();
	}

	@Override
	public EmployeeDTO findById(long id) {
		EmployeeEntity entity = employeeRepository.findOne(id);
		return employeeConverter.toDTO(entity);
	}

	@Override
	public String findRoleByUserId(long userID) {
		return null;
	}

	@Override
	public EmployeeDTO findOneByEmail(String email) {
		EmployeeEntity employeeEntity = employeeRepository.findOneByEmail(email);
		return employeeConverter.toDTO(employeeEntity);
	}

	@Override
	public EmployeeDTO save(EmployeeDTO dto) {
		EmployeeEntity entity;

		// Set user data
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(dto.getEmail());
		userDTO.setPassword(passwordEncode.encode(dto.getPassword()));
		userDTO.setRole(dto.getRole());
		userDTO.setStatus(1);
		
		UserEntity userEntity;

		if (dto.getImagePath() != null) {
			// convert image from base64 to bytes and write image to root dir
			String imagePath = dto.getImagePath().split(",")[1];
			byte[] decodeBase64 = Base64.getDecoder().decode(imagePath.getBytes());
			String uploadRootPath = context.getRealPath("template/upload");
			uploadFileUtil.writeOrUpdate(decodeBase64, uploadRootPath, dto.getAvatar());
		}
		
		// Check email user exist or not?
		userEntity = userRepository.findOneByUserNameAndStatus(userDTO.getUsername(), SystemConstant.ACTIVE_STATUS);
		if (userEntity != null && dto.getId() == null) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (dto.getId() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getUserID());
			EmployeeEntity oldEmpl = employeeRepository.findOne(dto.getId());
			UserEntity userUpdate = userConverter.toEntity(oldUser, userDTO);

			userEntity = userRepository.save(userUpdate);
			entity = employeeConverter.toEntity(oldEmpl, dto);
		} else {
			userEntity = userRepository.save(userConverter.toEntity(userDTO));
			
			//dto.setUserID(userID);
			entity = employeeConverter.toEntity(dto);
		}

		entity.setUser(userEntity);
		return employeeConverter.toDTO(employeeRepository.save(entity));
	}

	@Override
	public void delete(long id) {
		UserEntity userDelete = userRepository.findOne(id);

		// Set status to 0
		userDelete.setStatus(0);
		userRepository.save(userDelete);
	}

}

package com.nqhtour.converter;

import org.springframework.stereotype.Component;

import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.entity.EmployeeEntity;

@Component
public class EmployeeConverter {

	public EmployeeDTO toDTO(EmployeeEntity entity) {
		EmployeeDTO result = new EmployeeDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setUserID(entity.getUser().getId());
		result.setGender(entity.isGender());
		result.setEmail(entity.getEmail());
		result.setAddress(entity.getAddress());
		result.setPhoneNumber(entity.getPhoneNumber());
		result.setBirthday(entity.getBirthday());
		result.setAvatar(entity.getAvatar());

		result.setUsername(entity.getUser().getUserName());
		result.setPassword(entity.getUser().getPassword());
		result.setRole(entity.getUser().getRole());
		result.setStatus(entity.getUser().getStatus());
		
		return result;
	}

	public EmployeeEntity toEntity(EmployeeDTO dto) {
		EmployeeEntity result = new EmployeeEntity();
		result.setName(dto.getName());
		result.setGender(dto.isGender());
		result.setEmail(dto.getEmail());
		result.setAddress(dto.getAddress());
		result.setPhoneNumber(dto.getPhoneNumber());
		result.setBirthday(dto.getBirthday());
		result.setAvatar(dto.getAvatar());
		
		return result;
	}

	// For update
	public EmployeeEntity toEntity(EmployeeEntity oldEmpl, EmployeeDTO dto) {
		oldEmpl.setName(dto.getName());
		oldEmpl.setGender(dto.isGender());
		oldEmpl.setEmail(dto.getEmail());
		oldEmpl.setAddress(dto.getAddress());
		oldEmpl.setPhoneNumber(dto.getPhoneNumber());
		oldEmpl.setBirthday(dto.getBirthday());
		oldEmpl.setAvatar(dto.getAvatar());
		
		return oldEmpl;
	}
}

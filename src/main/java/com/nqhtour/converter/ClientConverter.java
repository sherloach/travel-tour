package com.nqhtour.converter;

import org.springframework.stereotype.Component;

import com.nqhtour.dto.ClientDTO;
import com.nqhtour.entity.ClientEntity;

@Component
public class ClientConverter {

	public ClientDTO toDTO(ClientEntity entity) {
		ClientDTO result = new ClientDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setUserID(entity.getUser().getId());
		result.setGender(entity.isGender());
		result.setEmail(entity.getEmail());
		result.setPhoneNumber(entity.getPhoneNumber());

		result.setUsername(entity.getUser().getUserName());
		result.setPassword(entity.getUser().getPassword());
		result.setRole(entity.getUser().getRole());
		result.setStatus(entity.getUser().getStatus());
		
		return result;
	}

	public ClientEntity toEntity(ClientDTO dto) {
		ClientEntity result = new ClientEntity();
		result.setName(dto.getName());
		result.setGender(dto.isGender());
		result.setEmail(dto.getEmail());
		result.setPhoneNumber(dto.getPhoneNumber());
		
		return result;
	}

	// For update
	public ClientEntity toEntity(ClientEntity oldClient, ClientDTO dto) {
		oldClient.setName(dto.getName());
		oldClient.setGender(dto.isGender());
		oldClient.setEmail(dto.getEmail());
		oldClient.setPhoneNumber(dto.getPhoneNumber());
		
		return oldClient;
	}
}

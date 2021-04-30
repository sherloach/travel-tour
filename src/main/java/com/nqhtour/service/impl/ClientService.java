package com.nqhtour.service.impl;

import com.nqhtour.entity.ClientTourEntity;
import com.nqhtour.repository.ClientTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nqhtour.constant.SystemConstant;
import com.nqhtour.converter.ClientConverter;
import com.nqhtour.converter.UserConverter;
import com.nqhtour.dto.ClientDTO;
import com.nqhtour.dto.UserDTO;
import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.ClientRepository;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IClientService;

@Service
public class ClientService implements IClientService {
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ClientConverter clientConverter;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TourRepository tourRepository;

	@Autowired
	ClientTourRepository clientTourRepository;
	
	@Autowired
	UserConverter userConverter;

	@Autowired
	PasswordEncoder passwordEncode;

	@Override
	public ClientDTO save(ClientDTO dto) {
		ClientEntity entity = new ClientEntity();
		
		// Set user data
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(dto.getEmail());
		userDTO.setPassword(passwordEncode.encode(dto.getPassword()));
		userDTO.setRole("CLIENT");
		userDTO.setStatus(1);

		UserEntity userEntity = null;
		// Check email user exist or not?
		userEntity = userRepository.findOneByUserNameAndStatus(userDTO.getUsername(), SystemConstant.ACTIVE_STATUS);
		if (userEntity != null) {
			throw new ArrayIndexOutOfBoundsException();
			/*ClientDTO empty = null;
			return empty;*/
		}

		if (dto.getId() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getUserID());
			ClientEntity oldClient = clientRepository.findOne(dto.getId());
			
			UserEntity userUpdate = userConverter.toEntity(oldUser, userDTO);
			userEntity = userRepository.save(userUpdate);
			entity = clientConverter.toEntity(oldClient, dto);
		} else {
			userEntity = userRepository.save(userConverter.toEntity(userDTO));
			
			//dto.setUserID(userID);
			entity = clientConverter.toEntity(dto);
		}

		entity.setUser(userEntity);
		return clientConverter.toDTO(clientRepository.save(entity));
	}

	public boolean booking(Long idClient, TourEntity tourEntity, int nuTickets) {
		// Update current tickets available
		int currentGroupSize = tourEntity.getCurrentGroupSize() + nuTickets;
		tourEntity.setCurrentGroupSize(currentGroupSize);
		tourRepository.save(tourEntity);

		ClientTourEntity clientTourEntity = new ClientTourEntity();
		ClientEntity clientEntity = clientRepository.findOne(idClient);
		clientTourEntity.setClientEntity(clientEntity);
		clientTourEntity.setTourEntity(tourEntity);
		clientTourEntity.setNuTickets(nuTickets);
		/*clientEntity.getTours().add(clientTourEntity);
		clientRepository.save(clientEntity);*/
		clientTourRepository.save(clientTourEntity);
		return true;
	}

	@Override
	public ClientDTO findById(long id) {
		ClientEntity entity = clientRepository.findOne(id);
		return clientConverter.toDTO(entity);
	}

	@Override
	public ClientDTO findByEmail(String email) {
		ClientEntity entity = clientRepository.findOneByEmail(email);
		return clientConverter.toDTO(entity);
	}


	@Override
	public boolean checkBookingExist(Long idClient, Long idTour) {
		/*ClientEntity entity = clientRepository.findOne(idClient);
		for (ClientTourEntity tour : entity.getTours()) {
			if (tour.getTourEntity().getId().equals(idTour)) {
				return false;
			}
		}
		return true;*/
		ClientEntity client = clientRepository.findOne(idClient);
		TourEntity tour = tourRepository.findOne(idTour);
		ClientTourEntity entity = clientTourRepository.findOneByClientEntityAndTourEntity(client, tour);
		if (entity == null) {
			return true;
		}
		return false;
	}

}

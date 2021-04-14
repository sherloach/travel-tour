package com.nqhtour.api.web;


import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.service.impl.TourService;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nqhtour.constant.SystemConstant;
import com.nqhtour.dto.ClientDTO;
import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.ClientRepository;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IClientService;

import java.io.IOException;

@RestController(value = "ClientAPIOfWeb")
public class ClientAPI {
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private TourRepository tourRepository;

	@GetMapping("/api/client/{id}")
	private ClientDTO readClient(@PathVariable Long id) {
		ClientDTO model = clientService.findById(id);
		return model;
	}
	
	@PostMapping("/api/client")	
	public ClientDTO createClient(@RequestBody ClientDTO client) {
		return clientService.save(client);
	}

	@PutMapping("/api/client")	
	public ClientDTO updateClient(@RequestBody ClientDTO oldClient) {
		return clientService.save(oldClient);
	}

	@PostMapping("/api/client/checkemail")
	public boolean checkEmailExist(@RequestBody String username) {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if (userEntity == null) {
			return false;
		}

		return true;
	}

	@PostMapping("/api/client/booking")
	public String booking(@RequestBody String data) throws IOException {
		JsonNode parent = new ObjectMapper().readTree(data);
		String email = parent.get("email").asText();
		String tourId = parent.get("tourId").asText();
		String nuTickets = parent.get("nuTickets").asText();

		ClientEntity entity = clientRepository.findOneByEmail(email);
		if (entity == null) {
			return "This email does not match any Client account!";
		}

		TourEntity tourEntity = tourRepository.findOne(Long.parseLong(tourId));
		if (tourEntity == null) {
			return "This Tour ID is not valid!";
		}

		// TODO: validate number of tickets bigger than maxgroupsize

		Long idClient = entity.getId();
		// Check ìf Client has booked this tour before or not?
		boolean exist = clientService.checkBookingExist(idClient, Long.parseLong(tourId));
		if (exist) {
			return String.valueOf(clientService.booking(idClient, tourEntity, Integer.parseInt(nuTickets)));
		} else {
			return "Client paid for this tour!";
		}
	}

	@PostMapping("/api/client/tour")
	public String checkBookingExist (@RequestBody String data) throws IOException {
		JsonNode parent = new ObjectMapper().readTree(data);
		String email = parent.get("email").asText();
		String tourId = parent.get("tourId").asText();

		ClientEntity entity = clientRepository.findOneByEmail(email);
		if (entity == null) {
			return "This email does not match any Client account!";
		}

		TourEntity tourEntity = tourRepository.findOne(Long.parseLong(tourId));
		if (tourEntity == null) {
			return "This Tour ID is not valid!";
		}

		Long idClient = entity.getId();
		boolean exist = clientService.checkBookingExist(idClient, Long.parseLong(tourId));
		return String.valueOf(exist);
	}
}

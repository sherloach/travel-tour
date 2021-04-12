package com.nqhtour.api.web;


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
	public void booking(@RequestBody String data) throws IOException {
		JsonNode parent = new ObjectMapper().readTree(data);
		String email = parent.get("email").asText();
		String tourId = parent.get("tourId").asText();

		ClientEntity entity = clientRepository.findOneByEmail(email);
		Long client = entity.getId();
		Long tour = Long.parseLong(tourId);
		clientService.booking(client, tour);
	}

	/*@PostMapping("/api/client/tour")
	public String checkBookingExist (@RequestBody String text) {
		String[] str = text.split(" ");
		ClientEntity entity = clientRepository.findOneByEmail(str[0]);
		Long idClient = entity.getId();
		boolean exist = clientService.checkBookingExist(idClient, Long.parseLong(str[1]));
		return String.valueOf(exist);
	}*/

	@PostMapping("/api/client/tour")
	public String checkBookingExist (@RequestBody String data) throws IOException {
		JsonNode parent = new ObjectMapper().readTree(data);
		String email = parent.get("email").asText();
		String clientId = parent.get("clientId").asText();

		ClientEntity entity = clientRepository.findOneByEmail(email);
		Long idClient = entity.getId();
		boolean exist = clientService.checkBookingExist(idClient, Long.parseLong(clientId));
		return String.valueOf(exist);
	}
}

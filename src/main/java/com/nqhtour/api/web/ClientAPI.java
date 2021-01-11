package com.nqhtour.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nqhtour.constant.SystemConstant;
import com.nqhtour.dto.ClientDTO;
import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.ClientRepository;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IClientService;

@RestController(value = "ClientAPIOfWeb")
public class ClientAPI {
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientRepository clientRepository;
	
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
	public void booking(@RequestBody String id) {
		String[] ids = id.split(" ");
		ClientEntity entity = clientRepository.findOneByEmail(ids[0]);
		Long client = entity.getId();
		Long tour = Long.parseLong(ids[1]);
		clientService.booking(client, tour);
	}

	@PostMapping("/api/client/tour")
	public String checkBookingExist (@RequestBody String text) {
		String[] str = text.split(" ");
		ClientEntity entity = clientRepository.findOneByEmail(str[0]);
		Long idClient = entity.getId();
		boolean exist = clientService.checkBookingExist(idClient, Long.parseLong(str[1]));
		return String.valueOf(exist);
	}
}

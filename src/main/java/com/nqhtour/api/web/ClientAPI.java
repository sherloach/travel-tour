package com.nqhtour.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nqhtour.dto.ClientDTO;
import com.nqhtour.service.IClientService;

@RestController(value = "ClientAPIOfWeb")
public class ClientAPI {
	@Autowired
	private IClientService clientService;
	
	@PostMapping("/api/client")	
	public ClientDTO createClient(@RequestBody ClientDTO client) {
		return clientService.save(client);
	}

	@PutMapping("/api/client")	
	public ClientDTO updateClient(@RequestBody ClientDTO oldClient) {
		return clientService.save(oldClient);
	}
}

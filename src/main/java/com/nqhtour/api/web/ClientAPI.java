package com.nqhtour.api.web;

import com.mysql.cj.xdevapi.Client;
import com.nqhtour.dto.ClientTourDTO;
import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.repository.TourRepository;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nqhtour.constant.SystemConstant;
import com.nqhtour.dto.ClientDTO;
import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.ClientRepository;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IClientService;

import javax.mail.MessagingException;
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

	@PostMapping("/api/client/email")
	private ClientDTO readClientByEmail(@RequestBody String data) throws IOException {
		JsonNode parent = new ObjectMapper().readTree(data);
		String email = parent.get("email").asText();

		ClientDTO model = clientService.findByEmail(email);
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
	public String booking(@RequestBody String data) throws IOException, MessagingException {
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

	@PostMapping("/api/client/cancellation")
	public String cancelBooking(@RequestBody String data) throws IOException {
		JsonNode parent = new ObjectMapper().readTree(data);
		String email = parent.get("email").asText();
		String tourId = parent.get("tourId").asText();

		ClientEntity entity = clientRepository.findOneByEmail(email);
		//Long idClient = entity.getId();
		clientService.deleteTourBooking(entity, Long.parseLong(tourId));

		return "true";
	}

	@PostMapping("/api/client/mytour")
	private ClientTourDTO myTour(@RequestBody String data) throws IOException {
		JsonNode parent = new ObjectMapper().readTree(data);
		String email = parent.get("email").asText();
		ClientTourDTO model = new ClientTourDTO();
		model.setListResult(clientService.myTour(email));
		return model;
	}
}

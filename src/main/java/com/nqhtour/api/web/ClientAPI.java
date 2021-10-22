package com.nqhtour.api.web;

import com.nqhtour.dto.BookingDTO;
import com.nqhtour.dto.ClientTourDTO;
import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.service.IBookingService;
import com.nqhtour.service.ITourService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
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
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController(value = "ClientAPIOfWeb")
public class ClientAPI {
	@Autowired
	private IClientService clientService;

	@Autowired
	private IBookingService bookingService;

	@Autowired
	private ITourService tourService;
	
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
	private ClientDTO readClientByEmail(@RequestBody ClientDTO client) throws IOException {
		ClientDTO model = clientService.findByEmail(client.getEmail());
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

	@PostMapping("/api/booking")
	public BookingDTO booking(@RequestBody BookingDTO booking) throws IOException, MessagingException {
		return bookingService.save(booking);
	}

	@GetMapping("/api/booking/checkout-session")
	public String createSessionCheckout(@RequestParam("instourid") Long instourId, @RequestParam("clientid") Long clientId, @RequestParam("tourid") Long tourId,
										@RequestParam("adultq") Integer adultQuantity, @RequestParam("childq") Integer childrenQuantity) throws StripeException {
		TourDTO tourDTO = tourService.findById(tourId);
		ClientDTO clientDTO = clientService.findById(clientId);

		Stripe.apiKey = "sk_test_51JOdvxDH1bc0ILeAvCCsB3MAp4z40gk7sFYmndAd8X8ce6lB7ILkM9THmKzM3Jb6zLOGvgUVYEAMsfr883Sx7DWh00aWCONBdO";
		SessionCreateParams params =
			SessionCreateParams.builder()
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.PAYMENT)
				.setCustomerEmail(clientDTO.getEmail())
				.setSuccessUrl("http://localhost:8080/tour/payment/success?instourid=" + instourId + "&clientid=" + clientId + "&adultq=" + adultQuantity + "&childq=" + childrenQuantity + "&paid=1")
				.setCancelUrl("http://localhost:8080/tour?id=" + tourId)
				.addLineItem(
					SessionCreateParams.LineItem.builder()
						.setQuantity(1L)
						.setPriceData(
							SessionCreateParams.LineItem.PriceData.builder()
								.setCurrency("vnd")
								.setUnitAmount(tourDTO.getAdultPrice() * adultQuantity + tourDTO.getChildrenPrice() * childrenQuantity)
								.setProductData(
									SessionCreateParams.LineItem.PriceData.ProductData.builder()
										.setName(tourDTO.getName())
										.setDescription(tourDTO.getSummary())
										.addImage("https://www.natours.dev/img/tours/" + tourDTO.getImage())
										.build())
								.build())
						.build())
				.build();
		Session session = Session.create(params);

		return session.getUrl();
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

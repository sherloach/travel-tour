package com.nqhtour.controller.web;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import com.nqhtour.api.HttpAPI;
import com.nqhtour.dto.*;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.service.*;
import com.nqhtour.service.impl.RouteService;
import com.nqhtour.util.ServerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "TourControllerOfWeb")
public class TourController {

	@Autowired
	private HttpAPI httpAPI;

	@Autowired
	private IClientService clientService;

	@Autowired
	private IInstourService instourService;

	@Autowired
	private IBookingService bookingService;

	@Autowired
	private ITourService tourService;

	@Autowired
	private IRouteService routeService;

	@Autowired
	private ServerName serverName;

	@RequestMapping(value = "/tour", method = RequestMethod.GET)
	public ModelAndView showTour(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/tour/tour");
		TourDTO model = httpAPI.getTourDTO(serverName.localUrl + "/api/tours/" + id);
		mav.addObject("model", model);

		return mav;
	}

	@RequestMapping(value = "/tour/repayment", method = RequestMethod.GET)
	public ModelAndView showRepaymentTour(@RequestParam("instourid") Long id, @RequestParam("email") String email, @RequestParam("tourid") Long tourId,
										  @RequestParam("adultq") Integer adultQuantity, @RequestParam("childq") Integer childrenQuantity,
										  HttpServletRequest request) {
		String repaymentView = "web/tour/repayment";
		String errorView = "errorpage";
		ModelAndView mav = new ModelAndView(repaymentView);
		TourDTO model = httpAPI.getTourDTO(serverName.localUrl + "/api/tours/" + id);
		ClientDTO client = clientService.findByEmail(email);
		InstourDTO instour = instourService.findById(id);
		mav.addObject("instour", instour);
		mav.addObject("client", client);
		mav.addObject("adultQuantity", adultQuantity);
		mav.addObject("childrenQuantity", childrenQuantity);
		mav.addObject("tourId", tourId);

		// TODO: 1. thêm param idClient để ràng buộc khi người dùng nhập trực tiếp url vào browser, khi nào sẽ vượt qua được hàm check
		//		2. hết vé thì không book được, nên phải xét điều kiện hết vé trong hàm này luôn

		return mav;
	}

	@RequestMapping(value = "/tour/payment/success", method = RequestMethod.GET)
	public ModelAndView showSuccessPaymentPage(@RequestParam(value = "instourid") Long instourId, @RequestParam("clientid") Long clientId, @RequestParam("paid") Integer paid,
											   @RequestParam("adultq") Integer adultQuantity, @RequestParam("childq") Integer childrenQuantity, @RequestParam("tourid") Long tourid) throws MessagingException {
		ModelAndView mav = new ModelAndView("web/tour/paymentSuccess");
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setInstourId(instourId);
		bookingDTO.setClientId(clientId);
		bookingDTO.setAdultQuantity(adultQuantity);
		bookingDTO.setChildrenQuantity(childrenQuantity);
		if (paid == 1) {
			bookingDTO.setPaid(true);
		} else {
			bookingDTO.setPaid(false);
		}
		bookingService.save(bookingDTO);

		TourDTO tourDTO = tourService.findById(tourid);
		Long total = adultQuantity * tourDTO.getAdultPrice() + childrenQuantity * tourDTO.getChildrenPrice();
		int duration = tourDTO.getDuration();
		clientService.sendEmail(adultQuantity, childrenQuantity, total, duration, tourDTO.getDestination(), tourDTO.getName(), tourDTO.getImage());

		return mav;
	}

	@RequestMapping(value = "/tour/checkout", method = RequestMethod.GET)
	public ModelAndView checkoutTour(@RequestParam("id") Long id, @RequestParam("nuTickets") Long nuTickets) {
		ModelAndView mav = new ModelAndView("web/tour/checkout");
		TourDTO model = httpAPI.getTourDTO(serverName.localUrl + "/api/tours/" + id);
		mav.addObject("model", model);
		mav.addObject("nutickets", nuTickets);
		
		return mav;
	}

	@RequestMapping(value = "/tour/search", method = RequestMethod.GET)
	public ModelAndView searchTour(@RequestParam(value = "id", required = false) Long routeId) {
		ModelAndView mav = new ModelAndView("web/tour/search");
		TourDTO tourDTO = new TourDTO();
		tourDTO.setListResult(tourService.findAllByRouteId(routeId));
		RouteDTO routeDTO = new RouteDTO();
		routeDTO.setListResult(routeService.findAll());
//		if (key.contains(" ")) {
//			key = key.replace(" ", "-");
//		}
//		String apiSearch = serverName.localUrl + "/api/tours/search/" + key;
//		TourDTO model = httpAPI.getTourDTO(apiSearch);
//		mav.addObject("model", model);
		mav.addObject("model", tourDTO.getListResult());
		mav.addObject("routes", routeDTO.getListResult());

		return mav;
	}
}

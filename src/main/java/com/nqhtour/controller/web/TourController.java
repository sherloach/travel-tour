package com.nqhtour.controller.web;

import javax.servlet.http.HttpServletRequest;

import com.nqhtour.api.HttpAPI;
import com.nqhtour.util.ServerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.service.ITourService;

@Controller(value = "TourControllerOfWeb")
public class TourController {

	@Autowired
	private HttpAPI httpAPI;

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
	public ModelAndView showRepaymentTour(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/tour/repayment");
		TourDTO model = httpAPI.getTourDTO(serverName.localUrl + "/api/tours/" + id);
		mav.addObject("model", model);

		// TODO: 1. thêm param idClient để ràng buộc khi người dùng nhập trực tiếp url vào browser, khi nào sẽ vượt qua được hàm check
		//		2. hết vé thì không book được

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
}

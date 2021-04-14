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
		TourDTO model = httpAPI.getTourDTO(serverName.herokuUrl + "/api/tours/" + id);
		mav.addObject("model", model);

		return mav;
	}

	@RequestMapping(value = "/tour/checkout", method = RequestMethod.GET)
	public ModelAndView checkoutTour(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/tour/checkout");
		TourDTO model = httpAPI.getTourDTO(serverName.herokuUrl + "/api/tours/" + id);
		mav.addObject("model", model);
		
		return mav;
	}
}

package com.nqhtour.controller.web;

import javax.servlet.http.HttpServletRequest;

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
	private ITourService tourService;

	@RequestMapping(value = "/tour", method = RequestMethod.GET)
	public ModelAndView showTour(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/tour/tour");	
		TourDTO model = new TourDTO();
		model = tourService.findById(id);
		mav.addObject("model", model);

		return mav;
	}

}

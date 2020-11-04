package com.nqhtour.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.service.ITourService;

@Controller(value = "TourControllerOfAdmin")
public class TourController {
	@Autowired
	private ITourService tourService;

	@RequestMapping(value = "/admin/tour/list", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		TourDTO model = new TourDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("/admin/tour/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(tourService.findAll(pageable));
		model.setTotalItem(tourService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);

		return mav;
	}

	// Add and Edit Tours
	@RequestMapping(value = "/admin/tour/edit", method = RequestMethod.GET)
	public ModelAndView editTour(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/tour/edit");
		TourDTO model = new TourDTO();

		// Add new tour
		if (id != null) {
			model = tourService.findById(id);
		}
		mav.addObject("model", model);

		return mav;
	}
}

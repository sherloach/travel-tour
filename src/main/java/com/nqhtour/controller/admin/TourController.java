package com.nqhtour.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.nqhtour.util.MessageUtil;

@Controller(value = "TourControllerOfAdmin")
public class TourController {
	@Autowired
	private ITourService tourService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/tour/list", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		TourDTO model = new TourDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("/admin/tour/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(tourService.findAll(pageable));
		model.setTotalItem(tourService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);

		return mav;
	}

	// Add and Edit Tours
	@RequestMapping(value = "/admin/tour/edit", method = RequestMethod.GET)
	public ModelAndView editTour(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/tour/edit");
		TourDTO model = new TourDTO();

		// Add new tour
		if (id != null) {
			model = tourService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);

		return mav;
	}
}

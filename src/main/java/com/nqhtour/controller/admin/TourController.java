package com.nqhtour.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.nqhtour.api.HttpAPI;
import com.nqhtour.dto.LocationDTO;
import com.nqhtour.dto.RouteDTO;
import com.nqhtour.dto.TourLocationDTO;
import com.nqhtour.service.ILocationService;
import com.nqhtour.service.IRouteService;
import com.nqhtour.util.ServerName;
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
	private HttpAPI httpAPI;

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private ServerName serverName;

	@Autowired
	private IRouteService routeService;

	@Autowired
	private ITourService tourService;

	@Autowired
	private ILocationService locationService;

	@RequestMapping(value = "/admin/tour/list", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		String api = serverName.localUrl + "/api/tours/" + page + "/" + limit;
		TourDTO model = httpAPI.getTourDTO(api);
		model.setPage(page);
		model.setLimit(limit);
		model.setTotalItem(httpAPI.getTotal(serverName.localUrl + "/api/tours/count"));
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

		ModelAndView mav = new ModelAndView("/admin/tour/list");
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
			model = httpAPI.getTourDTO(serverName.localUrl + "/api/tours/" + id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);

		RouteDTO routeDTO = new RouteDTO();
		routeDTO.setListResult(routeService.findAll());
		mav.addObject("route", routeDTO.getListResult());

		return mav;
	}

	@RequestMapping(value = "/admin/tour/edit/location/edit", method = RequestMethod.GET)
	public ModelAndView editLocationOnTour(@RequestParam(value = "id") Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/tour/editLocation");
		TourDTO tourDTO = tourService.findById(id);
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setListResult(locationService.findAll());

		mav.addObject("model", tourDTO);
		mav.addObject("locations", locationDTO.getListResult());
		return mav;
	}
}

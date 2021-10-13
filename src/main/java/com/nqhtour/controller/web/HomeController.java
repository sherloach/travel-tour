package com.nqhtour.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nqhtour.api.HttpAPI;
import com.nqhtour.dto.RouteDTO;
import com.nqhtour.service.IRouteService;
import com.nqhtour.util.ServerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.util.MessageUtil;

@Controller(value="web")
public class HomeController {
	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private HttpAPI httpAPI;

	@Autowired
	private IRouteService routeService;

	@Autowired
	private ServerName serverName;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("/web/home");

		TourDTO model = httpAPI.getTourDTO(serverName.localUrl + "/api/tours/1/9");
		Pageable pageable = new PageRequest(0, 6);
		RouteDTO routeDTO = new RouteDTO();
		routeDTO.setListResult(routeService.findAll(pageable));

		// TODO: show tours that have not been sold out yet:
		// 		 - Write a tours finding func that maxGroupSize equals People
		mav.addObject("model", model);
		mav.addObject("routes", routeDTO.getListResult());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("/login");
		return mav;
	}

	// TODO: fix redirect when submit, bcrypt password
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/web/signup");
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}

	// logout() do Spring security cung cap, se remove doi tuong dang dang nhap vao he thong
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/login?accessDenied");
	}
}

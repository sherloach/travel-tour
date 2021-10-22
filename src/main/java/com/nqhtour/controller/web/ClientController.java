package com.nqhtour.controller.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.nqhtour.dto.BookingDTO;
import com.nqhtour.dto.TourDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nqhtour.dto.ClientDTO;
import com.nqhtour.service.impl.ClientService;
import com.nqhtour.util.MessageUtil;

@Controller(value = "UserControllerOfWeb")
public class ClientController {
	@Autowired
	private ClientService clientSerivce;

	@Autowired
	private MessageUtil messageUtil;

	//Edit client
	@RequestMapping(value = "/me/booking", method = RequestMethod.GET)
	public ModelAndView editUser() {
		ModelAndView mav = new ModelAndView("web/user/booking");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = "";
		if (principal instanceof UserDetails) {
			email = (((UserDetails) principal).getUsername());
		} else {
			email = principal.toString();
		}
		ClientDTO model = clientSerivce.findByEmail(email);
		mav.addObject("client", model);

		return mav;
	}
	 
}

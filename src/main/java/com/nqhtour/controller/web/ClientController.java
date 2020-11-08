package com.nqhtour.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nqhtour.dto.ClientDTO;
import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.service.impl.ClientService;
import com.nqhtour.util.MessageUtil;

@Controller(value = "UserControllerOfWeb")
public class ClientController {
	@Autowired
	private ClientService clientSerivce;

	@Autowired
	private MessageUtil messageUtil;

	//Edit client
	@RequestMapping(value = "/web/client/edit", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/user/edit");
		ClientDTO model = new ClientDTO();

		// Add new client
		if (id != null) {
			model = clientSerivce.findById(id);
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

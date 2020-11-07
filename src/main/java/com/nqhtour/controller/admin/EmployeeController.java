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

import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.service.impl.EmployeeService;
import com.nqhtour.util.MessageUtil;

@Controller(value = "UserControllerOfAdmin")
public class EmployeeController {
	@Autowired
	private EmployeeService emplService;

	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/admin/empl/list", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		EmployeeDTO model = new EmployeeDTO();
		model.setPage(page);
		model.setLimit(limit);
		
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(emplService.findAll(pageable));
		model.setTotalItem(emplService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		
		ModelAndView mav = new ModelAndView("/admin/user/list");
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		
		return mav;
	}
	
	// Add and Edit Tours
	@RequestMapping(value = "/admin/empl/edit", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		EmployeeDTO model = new EmployeeDTO();

		// Add new tour
		if (id != null) {
			model = emplService.findById(id);
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

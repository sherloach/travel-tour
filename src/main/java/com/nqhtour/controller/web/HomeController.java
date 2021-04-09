package com.nqhtour.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nqhtour.api.HttpAPI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
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
import com.nqhtour.service.impl.TourService;
import com.nqhtour.util.MessageUtil;

@Controller(value="web")
public class HomeController {
	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private HttpAPI httpAPI;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("/web/home");
		TourDTO model = httpAPI.getTourDTO("http://localhost:8080/api/tours/1/9");

		// TODO: show tours that have not been sold out yet:
		// 		 - Write a tours finding func that maxGroupSize equals People
		mav.addObject("model", model);
		return mav;
	}

	/*@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() throws Exception {
		ModelAndView mav = new ModelAndView("/web/home");
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try
		{
			//Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
			//Choice depends on type of method you will be invoking.
			HttpGet getRequest = new HttpGet("http://localhost:8080/api/tours/1/9");

			//Set the API media type in http accept header
			getRequest.addHeader("accept", "application/json");

			//Send the request; It will immediately return the response in HttpResponse object
			HttpResponse response = httpClient.execute(getRequest);

			//verify the valid error code first
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200)
			{
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}

			// Now pull back the response object
			HttpEntity httpEntity = response.getEntity();
			String apiOutput = EntityUtils.toString(httpEntity);

			ObjectMapper mapper = new ObjectMapper();
			TourDTO model = mapper.readValue(apiOutput, TourDTO.class);

			mav.addObject("model", model);
		}
		finally
		{
			//Important: Close the connect
			httpClient.getConnectionManager().shutdown();
			return mav;
		}
	}*/

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

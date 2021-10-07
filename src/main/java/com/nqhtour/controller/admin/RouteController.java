package com.nqhtour.controller.admin;

import com.nqhtour.api.HttpAPI;
import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.dto.RouteDTO;
import com.nqhtour.dto.TourDTO;
import com.nqhtour.service.IEmployeeService;
import com.nqhtour.service.IRouteService;
import com.nqhtour.service.ITourService;
import com.nqhtour.service.IUserService;
import com.nqhtour.util.MessageUtil;
import com.nqhtour.util.ServerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "RouteControllerOfAdmin")
public class RouteController {

    @Autowired
    private HttpAPI httpAPI;

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private IRouteService routeService;

    @Autowired
    private ITourService tourService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ServerName serverName;

    @RequestMapping(value = "/admin/route/list", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
        RouteDTO routeDTO = new RouteDTO();
        Pageable pageable = new PageRequest(page - 1, limit);
        routeDTO.setListResult(routeService.findAll(pageable));
        routeDTO.setPage(page);
        routeDTO.setLimit(limit);
        routeDTO.setTotalItem(routeService.getTotalItem());
        routeDTO.setTotalPage((int) Math.ceil((double) routeService.getTotalItem() / 6));

        ModelAndView mav = new ModelAndView("/admin/route/list");
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }

        mav.addObject("model", routeDTO);
        return mav;
    }

    @RequestMapping(value = "/admin/route/list/tour", method = RequestMethod.GET)
    public ModelAndView showListTourOnRoute(@RequestParam("route") Long routeId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/admin/route/listTour");
        TourDTO tourDTO = new TourDTO();
        tourDTO.setListResult(tourService.findAllByRouteId(routeId));
        mav.addObject("model", tourDTO);

        return mav;
    }

    @RequestMapping(value = "/admin/route/list/tour/instour", method = RequestMethod.GET)
    public ModelAndView showListInstourOnTour(@RequestParam("tour") Long tourId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/admin/instour/list");
        TourDTO tourDTO = tourService.findById(tourId);
        EmployeeDTO guides = new EmployeeDTO();
        guides.setListResult(userService.findAllByRole("EMPLOYEE"));

        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }

        mav.addObject("tour", tourDTO);
        mav.addObject("guides", guides.getListResult());

        return mav;
    }
}

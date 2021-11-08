package com.nqhtour.controller.admin;

import com.nqhtour.dto.BookingDTO;
import com.nqhtour.dto.RouteDTO;
import com.nqhtour.service.IBookingService;
import com.nqhtour.service.IRouteService;
import com.nqhtour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "BookingControllerOfAdmin")
public class BookingController {
    @Autowired
    private IBookingService bookingService;

    @Autowired
    private ITourService tourService;

    @Autowired
    private IRouteService routeService;

    @RequestMapping(value = "/admin/booking/list", method = RequestMethod.GET)
    public ModelAndView showList() {
        ModelAndView mav = new ModelAndView("/admin/booking/list");
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setListResult(bookingService.findAll());
        mav.addObject("model", bookingDTO.getListResult());

        return mav;
    }

    @RequestMapping(value = "/admin/booking/list/detail", method = RequestMethod.GET)
    public ModelAndView showBookingDetail(@RequestParam("bookingid") Long id) {
        ModelAndView mav = new ModelAndView("/admin/booking/detail");
        BookingDTO bookingDTO = bookingService.findById(id);
        mav.addObject("model", bookingDTO);

        return mav;
    }

    @RequestMapping(value = "/admin/report/revenue", method = RequestMethod.GET)
    public ModelAndView showRevenueReport(@RequestParam("month") String month, @RequestParam("year") String year) {
        ModelAndView mav = new ModelAndView("/admin/report/revenue");
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setListResult(tourService.revenueByMonth(month, year));

        mav.addObject("revenues", bookingDTO.getListResult());
        mav.addObject("month", month);
        mav.addObject("year", year);

        return mav;
    }

    @RequestMapping(value = "/admin/report/quantity", method = RequestMethod.GET)
    public ModelAndView showNumberTicketReport(@RequestParam("month") String month, @RequestParam("year") String year, @RequestParam("routeid") Long routeId) {
        ModelAndView mav = new ModelAndView("/admin/report/quantity");
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setListResult(tourService.numberTicketByMonth(month, year, routeId));
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setListResult(routeService.findAll());

        mav.addObject("routes", routeDTO.getListResult());
        mav.addObject("numberTickets", bookingDTO.getListResult());
        mav.addObject("month", month);
        mav.addObject("year", year);

        return mav;
    }
}

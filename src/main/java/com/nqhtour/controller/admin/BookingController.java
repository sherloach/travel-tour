package com.nqhtour.controller.admin;

import com.nqhtour.dto.BookingDTO;
import com.nqhtour.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "BookingControllerOfAdmin")
public class BookingController {
    @Autowired
    private IBookingService bookingService;

    @RequestMapping(value = "/admin/booking/list", method = RequestMethod.GET)
    public ModelAndView showList() {
        ModelAndView mav = new ModelAndView("/admin/booking/list");
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setListResult(bookingService.findAll());
        mav.addObject("model", bookingDTO.getListResult());

        return mav;
    }
}

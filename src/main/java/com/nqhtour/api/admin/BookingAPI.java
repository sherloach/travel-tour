package com.nqhtour.api.admin;

import com.nqhtour.dto.BookingDTO;
import com.nqhtour.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "BookingAPIOfAdmin")
public class BookingAPI {
    @Autowired
    IBookingService bookingService;

    @GetMapping("/api/booking")
    public BookingDTO readBooking() {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setListResult(bookingService.findAll());
        return bookingDTO;
    }
}

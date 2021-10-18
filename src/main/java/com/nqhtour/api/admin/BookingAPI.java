package com.nqhtour.api.admin;

import com.nqhtour.dto.BookingDTO;
import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.dto.InvoiceDTO;
import com.nqhtour.service.IBookingService;
import com.nqhtour.service.IEmployeeService;
import com.nqhtour.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "BookingAPIOfAdmin")
public class BookingAPI {
    @Autowired
    IBookingService bookingService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IInvoiceService invoiceService;

    @GetMapping("/api/booking")
    public BookingDTO readBooking() {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setListResult(bookingService.findAll());
        return bookingDTO;
    }

    // approve booking and create invoice
    @PostMapping("/api/booking/invoice")
    public BookingDTO approveBooking(@RequestBody InvoiceDTO dto) {
        EmployeeDTO employeeDTO = employeeService.findOneByEmail(dto.getEmailEmployee());

        // Approve booking
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(dto.getBookingId());
        bookingDTO.setStatus("APPROVED");
        bookingDTO.setEmployeeId(employeeDTO.getId());

        // Create new invoice
        invoiceService.save(dto);

        return bookingService.save(bookingDTO);
    }

    @PostMapping("/api/booking/invoice/cancel")
    public BookingDTO cancelBooking(@RequestBody InvoiceDTO dto) {
        EmployeeDTO employeeDTO = employeeService.findOneByEmail(dto.getEmailEmployee());

        // Approve booking
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(dto.getBookingId());
        bookingDTO.setStatus("CANCELED");
        bookingDTO.setEmployeeId(employeeDTO.getId());

        return bookingService.save(bookingDTO);
    }

}

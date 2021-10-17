package com.nqhtour.service.impl;

import com.nqhtour.converter.EmployeeConverter;
import com.nqhtour.converter.InvoiceConverter;
import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.dto.InvoiceDTO;
import com.nqhtour.entity.BookingEntity;
import com.nqhtour.entity.EmployeeEntity;
import com.nqhtour.entity.InvoiceEntity;
import com.nqhtour.repository.BookingRepository;
import com.nqhtour.repository.EmployeeRepository;
import com.nqhtour.repository.InvoiceRepository;
import com.nqhtour.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private InvoiceConverter invoiceConverter;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    public InvoiceDTO findById(String invoiceId) {
        InvoiceEntity invoiceEntity = invoiceRepository.findOne(invoiceId);
        InvoiceDTO invoiceDTO = invoiceConverter.toDTO(invoiceEntity);
        invoiceDTO.setEmployee(employeeConverter.toDTO(invoiceEntity.getEmployee()));
        return invoiceDTO;
    }

    @Override
    public InvoiceDTO save(InvoiceDTO dto) {
        BookingEntity bookingEntity = bookingRepository.findOne(dto.getBookingId());
        EmployeeEntity employeeEntity = employeeRepository.findOne(dto.getEmployeeId());
        InvoiceEntity invoiceEntity;
        invoiceEntity = invoiceConverter.toEntity(dto);
        invoiceEntity.setEmployee(employeeEntity);
        invoiceEntity.setBooking(bookingEntity);
        return invoiceConverter.toDTO(invoiceRepository.save(invoiceEntity));
    }
}

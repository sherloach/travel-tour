package com.nqhtour.service.impl;

import com.nqhtour.converter.BookingConverter;
import com.nqhtour.converter.InvoiceConverter;
import com.nqhtour.dto.BookingDTO;
import com.nqhtour.entity.BookingEntity;
import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.InstourEntity;
import com.nqhtour.repository.BookingRepository;
import com.nqhtour.repository.ClientRepository;
import com.nqhtour.repository.EmployeeRepository;
import com.nqhtour.repository.InstourRepository;
import com.nqhtour.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingConverter bookingConverter;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InstourRepository instourRepository;

    @Autowired
    private InvoiceConverter invoiceConverter;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<BookingDTO> findAll() {
        List<BookingDTO> models = new ArrayList<>();
        List<BookingEntity> entities = bookingRepository.findAll();
        for (BookingEntity booking : entities) {
            BookingDTO bookingDTO = bookingConverter.toDTO(booking);
            models.add(bookingDTO);
        }

        return models;
    }

    @Override
    public BookingDTO findById(Long id) {
        BookingEntity bookingEntity = bookingRepository.findOne(id);
        BookingDTO bookingDTO = bookingConverter.toDTO(bookingEntity);
        if (bookingEntity.getInvoice() != null) {
            bookingDTO.setInvoice(invoiceConverter.toDTO(bookingEntity.getInvoice()));
        }

        return bookingDTO;
    }

    @Override
    public BookingDTO save(BookingDTO dto) {
        if (dto.getId() != null) {
            BookingEntity oldBooking = bookingRepository.findOne(dto.getId());
            // Update status of booking (pending, approved, cancel)
            oldBooking.setStatus(dto.getStatus());
            oldBooking.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
            return bookingConverter.toDTO(bookingRepository.save(oldBooking));
        } else {
            BookingEntity bookingEntity;
            bookingEntity = bookingConverter.toEntity(dto);
            ClientEntity clientEntity = clientRepository.findOne(dto.getClientId());
            InstourEntity instourEntity = instourRepository.findOne(dto.getInstourId());

            // Update new participants of instour
            int newParticipants = instourEntity.getParticipants() + bookingEntity.getAdultQuantity() + bookingEntity.getChildrenQuantity();
            instourEntity.setParticipants(newParticipants);
            instourRepository.save(instourEntity);

            bookingEntity.setClient(clientEntity);
            bookingEntity.setInstour(instourEntity);
            bookingEntity.setStatus("PENDING");
            return bookingConverter.toDTO(bookingRepository.save(bookingEntity));
        }
    }
}

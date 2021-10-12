package com.nqhtour.service;

import com.nqhtour.dto.BookingDTO;

import java.util.List;

public interface IBookingService {
    List<BookingDTO> findAll();
    BookingDTO findById(Long id);
    BookingDTO save(BookingDTO dto);
}

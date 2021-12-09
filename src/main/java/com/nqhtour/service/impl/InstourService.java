package com.nqhtour.service.impl;

import com.nqhtour.converter.BookingConverter;
import com.nqhtour.converter.InstourConverter;
import com.nqhtour.dto.BookingDTO;
import com.nqhtour.dto.InstourDTO;
import com.nqhtour.entity.BookingEntity;
import com.nqhtour.entity.EmployeeEntity;
import com.nqhtour.entity.InstourEntity;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.repository.BookingRepository;
import com.nqhtour.repository.EmployeeRepository;
import com.nqhtour.repository.InstourRepository;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.service.IInstourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstourService implements IInstourService {
    @Autowired
    InstourRepository instourRepository;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    InstourConverter instourConverter;

    @Autowired
    BookingConverter bookingConverter;

    @Override
    public List<InstourDTO> findAll(Pageable pageable) {
        List<InstourDTO> models = new ArrayList<>();
        List<InstourEntity> entities = instourRepository.findAll(pageable).getContent();
        for (InstourEntity item : entities) {
            InstourDTO instourDTO = instourConverter.toDTO(item);
            models.add(instourDTO);
        }

        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) instourRepository.count();
    }

    @Override
    public InstourDTO findById(long id) {
        InstourDTO instourDTO;
        InstourEntity instourEntity = instourRepository.findOne(id);
        List<BookingDTO> bookings = new ArrayList<>();
        for (BookingEntity item : instourEntity.getTours()) {
            BookingDTO booking = bookingConverter.toDTO(item);
            bookings.add(booking);
        }

        instourDTO = instourConverter.toDTO(instourEntity);
        instourDTO.setBookings(bookings);
        return instourDTO;
    }

    @Override
    public InstourDTO save(InstourDTO dto) {
        InstourEntity instourEntity;

        EmployeeEntity guide = employeeRepository.findOne(dto.getGuideId());
        TourEntity tour = tourRepository.findOne(dto.getTourId());

        if (dto.getId() != null) {
            InstourEntity oldInstour = instourRepository.findOne(dto.getId());
            instourEntity = instourConverter.toEntity(oldInstour, dto);

            // Update status of bookings with instour_id to 'completed'
            if (dto.getStatus().equals("COMPLETED")) {
                bookingRepository.completeStatus(oldInstour.getId());
            }
        } else {
            instourEntity = instourConverter.toEntity(dto);
            instourEntity.setParticipants(0);
            instourEntity.setStatus("OPEN");
        }

        instourEntity.setGuide(guide);
        instourEntity.setTour(tour);

        return instourConverter.toDTO(instourRepository.save(instourEntity));
    }

    @Override
    public void delete(long id) {
        instourRepository.delete(id);
    }
}

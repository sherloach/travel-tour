package com.nqhtour.converter;

import com.nqhtour.dto.BookingDTO;
import com.nqhtour.entity.BookingEntity;
import org.springframework.stereotype.Component;

@Component
public class BookingConverter {
    public BookingDTO toDTO(BookingEntity entity) {
        BookingDTO result = new BookingDTO();
        result.setId(entity.getId());
        result.setAdultQuantity(entity.getAdultQuantity());
        result.setChildrenQuantity(entity.getChildrenQuantity());
        result.setStatus(entity.getStatus());
        result.setPaid(entity.isPaid());
        result.setCreatedDate(entity.getCreatedDate());
        result.setClientId(entity.getClient().getId());
        result.setInstourId(entity.getInstour().getId());
        result.setTourName(entity.getInstour().getTour().getName());
        result.setClientName(entity.getClient().getName());
        result.setAdultPrice(entity.getInstour().getTour().getAdultPrice());
        result.setChildrenPrice(entity.getInstour().getTour().getChildrenPrice());
        if (result.getEmployeeId() != null) {
            result.setEmployeeId(entity.getEmployee().getId());
        }

        return result;
    }

    public BookingEntity toEntity(BookingDTO dto) {
        BookingEntity result = new BookingEntity();
        result.setAdultQuantity(dto.getAdultQuantity());
        result.setChildrenQuantity(dto.getChildrenQuantity());
        result.setPaid(dto.getPaid());
        result.setCreatedDate(dto.getCreatedDate());

        return result;
    }

    // For update
//    public BookingEntity toEntity(BookingEntity oldBooking, BookingDTO dto) {
//        oldBooking.setAdultQuantity(dto.getAdultQuantity());
//        oldBooking.setChildrenQuantity(dto.getChildrenQuantity());
//        oldBooking.setStatus(dto.getStatus());
//        oldBooking.setPaid(dto.getPaid());
//        oldBooking.setCreatedDate(dto.getCreatedDate());
//        oldBooking.setPaid(dto.getPaid());
//
//        return oldClient;
//    }
}

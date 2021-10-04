package com.nqhtour.converter;

import com.nqhtour.dto.TourLocationDTO;
import com.nqhtour.entity.TourLocationEntity;
import org.springframework.stereotype.Component;

@Component
public class TourLocationConverter {
    public TourLocationDTO toDTO(TourLocationEntity entity) {
        TourLocationDTO result = new TourLocationDTO();
        result.setTourId(entity.getTour().getId());
        result.setLocationId(entity.getLocation().getId());
        result.setDescription(entity.getDescription());
        result.setDay(entity.getDay());

        return result;
    }
}

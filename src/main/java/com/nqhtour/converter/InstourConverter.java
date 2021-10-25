package com.nqhtour.converter;

import com.nqhtour.dto.InstourDTO;
import com.nqhtour.entity.InstourEntity;
import org.springframework.stereotype.Component;

@Component
public class InstourConverter {
    public InstourDTO toDTO(InstourEntity entity) {
        InstourDTO result = new InstourDTO();
        result.setId(entity.getId());
        result.setGuideId(entity.getGuide().getId());
        result.setCreatedBy(entity.getCreatedBy());
        result.setParticipants(entity.getParticipants());
        result.setStatus(entity.getStatus());
        result.setStartDate(entity.getStartDate());
        result.setTourId(entity.getTour().getId());

        return result;
    }

    public InstourEntity toEntity(InstourDTO dto) {
        InstourEntity result = new InstourEntity();
        result.setCreatedBy(dto.getCreatedBy());
        result.setParticipants(dto.getParticipants());
        result.setStatus(dto.getStatus());
        result.setStartDate(dto.getStartDate());

        return result;
    }

    // For update
    public InstourEntity toEntity(InstourEntity oldTour, InstourDTO dto) {
        oldTour.setStatus(dto.getStatus());
        oldTour.setStartDate(dto.getStartDate());

        return oldTour;
    }
}

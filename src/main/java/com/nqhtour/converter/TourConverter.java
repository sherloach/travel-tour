package com.nqhtour.converter;

import org.springframework.stereotype.Component;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.TourEntity;

// Để có thể Dependency Injection, add anotation Component
@Component
public class TourConverter {

	public TourDTO toDTO(TourEntity entity) {
		TourDTO result = new TourDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setTourID(entity.getSlug());
		result.setDescription(entity.getDescription());
		result.setSummary(entity.getSummary());
		result.setDuration(entity.getDuration());
		result.setMaxGroupSize(entity.getMaxGroupSize());
		
		return result;
	}

	public TourEntity toEntity(TourDTO dto) {
		TourEntity result = new TourEntity();
		result.setName(dto.getName());
		result.setSlug(dto.getTourID());
		result.setDescription(dto.getDescription());
		result.setSummary(dto.getSummary());
		result.setDuration(dto.getDuration());
		result.setMaxGroupSize(dto.getMaxGroupSize());
		
		return result;
	}

	// For update
	public TourEntity toEntity(TourEntity oldTour, TourDTO dto) {
		oldTour.setName(dto.getName());
		oldTour.setSlug(dto.getTourID());
		oldTour.setDescription(dto.getDescription());
		oldTour.setSummary(dto.getSummary());
		oldTour.setDuration(dto.getDuration());
		oldTour.setMaxGroupSize(dto.getMaxGroupSize());
		
		return oldTour;
	}
}

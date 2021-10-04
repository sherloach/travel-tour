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
		result.setDuration(entity.getDuration());
		result.setMaxGroupSize(entity.getMaxGroupSize());
		result.setRatingsAverage(entity.getRatingsAverage());
		result.setRatingsQuantity(entity.getRatingsQuantity());
		result.setSummary(entity.getSummary());
		result.setDescription(entity.getDescription());
		result.setImage(entity.getImage());
		result.setAdultPrice(entity.getAdultPrice());
		result.setChildrenPrice(entity.getChildrenPrice());
		result.setCreatedBy(entity.getCreatedBy());
		result.setRouteId(entity.getRoute().getId());

		return result;
	}

	public TourEntity toEntity(TourDTO dto) {
		TourEntity result = new TourEntity();
		result.setName(dto.getName());
		result.setSlug(dto.getTourID());
		result.setDuration(dto.getDuration());
		result.setMaxGroupSize(dto.getMaxGroupSize());
		result.setRatingsAverage(dto.getRatingsAverage());
		result.setRatingsQuantity(dto.getRatingsQuantity());
		result.setSummary(dto.getSummary());
		result.setDescription(dto.getDescription());
		result.setImage(dto.getImage());
		result.setAdultPrice(dto.getAdultPrice());
		result.setChildrenPrice(dto.getChildrenPrice());
		result.setCreatedBy(dto.getCreatedBy());
		
		return result;
	}

	// For update
	public TourEntity toEntity(TourEntity oldTour, TourDTO dto) {
		oldTour.setName(dto.getName());
		oldTour.setSlug(dto.getTourID());
		oldTour.setDuration(dto.getDuration());
		oldTour.setMaxGroupSize(dto.getMaxGroupSize());
		oldTour.setRatingsAverage(dto.getRatingsAverage());
		oldTour.setRatingsQuantity(dto.getRatingsQuantity());
		oldTour.setSummary(dto.getSummary());
		oldTour.setDescription(dto.getDescription());
		oldTour.setImage(dto.getImage());
		oldTour.setAdultPrice(dto.getAdultPrice());
		oldTour.setChildrenPrice(dto.getChildrenPrice());
		oldTour.setCreatedBy(dto.getCreatedBy());
		
		return oldTour;
	}
}

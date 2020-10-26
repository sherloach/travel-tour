package com.nqhtour.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.service.ITourService;

@Service
public class TourService implements ITourService {

	@Autowired
	private TourRepository tourRepository;
	
	@Override
	public List<TourDTO> findAll() {
		List<TourDTO> models = new ArrayList<>();
		List<TourEntity> entities = tourRepository.findAll();
		for (TourEntity item : entities) {
			TourDTO tourDTO = new TourDTO();
			tourDTO.setName(item.getName());
			tourDTO.setTourID(item.getTourID());
			tourDTO.setDescription(item.getDescription());
			tourDTO.setSummary(item.getSummary());
			tourDTO.setDuration(item.getDuration());
			tourDTO.setEmployeeID(item.getEmployee().getId());
			tourDTO.setLocation(item.getLocation());
			tourDTO.setMaxGroupSize(item.getMaxGroupSize());
			tourDTO.setPrice(item.getPrice());
			tourDTO.setStartDate(item.getStartDate());

			models.add(tourDTO);
		}

		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) tourRepository.count();
	}

}

package com.nqhtour.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nqhtour.controller.admin.TourController;
import com.nqhtour.converter.TourConverter;
import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.service.ITourService;

@Service
public class TourService implements ITourService {

	@Autowired
	private TourRepository tourRepository;

	@Autowired
	private TourConverter tourConverter;
	
	// Khi lấy dữ liệu lên thì dữ liệu đó sẽ được gán vào Entity
	// Và để thao tác với dữ liệu đó, thì ta sẽ convert List Entity đó sang List DTO
	@Override
	public List<TourDTO> findAll(Pageable pageable) {
		List<TourDTO> models = new ArrayList<>();
		List<TourEntity> entities = tourRepository.findAll(pageable).getContent();
		for (TourEntity item : entities) {
			TourDTO tourDTO = tourConverter.toDTO(item);
			models.add(tourDTO);
		}

		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) tourRepository.count();
	}

	@Override
	public TourDTO findById(long id) {
		TourEntity entity = tourRepository.findOne(id);
		return tourConverter.toDTO(entity);
	}
}

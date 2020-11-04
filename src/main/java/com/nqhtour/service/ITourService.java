package com.nqhtour.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.nqhtour.dto.TourDTO;


public interface ITourService {
	List<TourDTO> findAll(Pageable pageable);
	int getTotalItem();
	TourDTO findById(long id);
}

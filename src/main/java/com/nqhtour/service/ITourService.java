package com.nqhtour.service;

import java.util.List;

import com.nqhtour.specification.TourSpecification;
import org.springframework.data.domain.Pageable;

import com.nqhtour.dto.TourDTO;


public interface ITourService {
	List<TourDTO> findAll(Pageable pageable);
	List<TourDTO> findAll(TourSpecification tourSpecification);
	int getTotalItem();
	TourDTO findById(long id);
	TourDTO save(TourDTO dto);
	void delete(Long id);
}

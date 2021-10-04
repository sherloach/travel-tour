package com.nqhtour.service;

import java.util.List;

import com.nqhtour.dto.TourLocationDTO;
import com.nqhtour.specification.TourSpecification;
import org.springframework.data.domain.Pageable;

import com.nqhtour.dto.TourDTO;


public interface ITourService {
	List<TourDTO> findAll(Pageable pageable);
	List<TourDTO> findAll(TourSpecification tourSpecification);
	int getTotalItem();
	TourDTO findById(long id);
	TourDTO save(TourDTO dto);
	TourLocationDTO save(TourLocationDTO dto);
	void delete(long id);
	List<TourDTO> findHotTours();
	List<TourDTO> findNewTours();
	List<TourDTO> getTopTourByMoney(String month,String year);
}

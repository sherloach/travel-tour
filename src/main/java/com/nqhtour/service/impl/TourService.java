package com.nqhtour.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import com.nqhtour.converter.TourLocationConverter;
import com.nqhtour.dto.TourLocationDTO;
import com.nqhtour.entity.LocationEntity;
import com.nqhtour.entity.RouteEntity;
import com.nqhtour.entity.TourLocationEntity;
import com.nqhtour.repository.LocationRepository;
import com.nqhtour.repository.RouteRepository;
import com.nqhtour.repository.TourLocationRepository;
import com.nqhtour.specification.TourSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nqhtour.controller.admin.TourController;
import com.nqhtour.converter.TourConverter;
import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.service.ITourService;
import com.nqhtour.util.StringUtil;
import com.nqhtour.util.UploadFileUtil;

@Service
public class TourService implements ITourService {

	@Autowired
	private TourRepository tourRepository;

	@Autowired
	private TourConverter tourConverter;

	@Autowired
	private TourLocationConverter tourLocationConverter;

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private TourLocationRepository tourLocationRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private UploadFileUtil uploadFileUtil;
	
	@Autowired
	private ServletContext context;
	
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
	public List<TourDTO> findAll(TourSpecification tourSpecification) {
		List<TourDTO> models = new ArrayList<>();
		List<TourEntity> entities = tourRepository.findAll(tourSpecification);
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

	@Override
	public TourDTO save(TourDTO dto) {
		TourEntity tourEntity;

		if (dto.getBase64() != null) {
			// convert image from base64 to bytes and write image to root dir
			String imagePath = dto.getBase64().split(",")[1];
			byte[] decodeBase64 = Base64.getDecoder().decode(imagePath.getBytes());
			String uploadRootPath = context.getRealPath("template/upload/tour");
			uploadFileUtil.writeOrUpdate(decodeBase64, uploadRootPath, dto.getImageCover());
		}

		if (dto.getId() != null) {
			TourEntity oldTour = tourRepository.findOne(dto.getId());
			tourEntity = tourConverter.toEntity(oldTour, dto);
		} else {
			dto.setCurrentGroupSize(0);
			tourEntity = tourConverter.toEntity(dto);
			tourEntity.setRatingsAverage(4.5f);
			tourEntity.setRatingsQuantity(0);
		}

		RouteEntity routeEntity = routeRepository.findOne(dto.getRouteId());
		tourEntity.setRoute(routeEntity);
		tourEntity.setSlug(StringUtil.createSlug(tourEntity.getName()));
		return tourConverter.toDTO(tourRepository.save(tourEntity));
	}

	@Override
	public TourLocationDTO save(TourLocationDTO dto) {
		TourLocationEntity tourLocationEntity = new TourLocationEntity();
		TourEntity tourEntity = tourRepository.findOne(dto.getTourId());
		LocationEntity locationEntity = locationRepository.findOne(dto.getLocationId());
		tourLocationEntity.setTour(tourEntity);
		tourLocationEntity.setLocation(locationEntity);
		tourLocationEntity.setDay(dto.getDay());
		tourLocationEntity.setDescription(dto.getDescription());

		return tourLocationConverter.toDTO(tourLocationRepository.save(tourLocationEntity));
	}

	@Override
	public void delete(long id) {
		tourRepository.delete(id);
	}

	@Override
	public List<TourDTO> findHotTours() {
		List<TourDTO> models = new ArrayList<>();
//		List<TourEntity> entities = tourRepository.findByHotTours();
//		for (TourEntity item : entities) {
//			TourDTO tourDTO = tourConverter.toDTO(item);
//			models.add(tourDTO);
//		}
		return models;
	}

	@Override
	public List<TourDTO> findNewTours() {
		List<TourDTO> models = new ArrayList<>();
//		List<TourEntity> entities = tourRepository.findByNewTours();
//		for (TourEntity item : entities) {
//			TourDTO tourDTO = tourConverter.toDTO(item);
//			models.add(tourDTO);
//		}
		return models;
	}

	@Override
	public List<TourDTO> getTopTourByMoney(String month,String year){
		List<TourDTO> models = new ArrayList<>();
//		List<TourEntity> entities = tourRepository.getByTopTourByMoney(month,year);
//		for (TourEntity item : entities) {
//			TourDTO tourDTO = tourConverter.toDTO(item);
//			models.add(tourDTO);
//		}
		return models;
	}
}

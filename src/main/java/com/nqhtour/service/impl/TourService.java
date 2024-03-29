package com.nqhtour.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import javax.servlet.ServletContext;

import com.nqhtour.converter.*;
import com.nqhtour.dto.*;
import com.nqhtour.entity.*;
import com.nqhtour.repository.LocationRepository;
import com.nqhtour.repository.RouteRepository;
import com.nqhtour.repository.TourLocationRepository;
import com.nqhtour.specification.TourSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nqhtour.controller.admin.TourController;
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
	private InstourConverter instourConverter;

	@Autowired
	private ReviewConverter reviewConverter;

	@Autowired
	private LocationConverter locationConverter;

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
			List<InstourDTO> listInstour = new ArrayList<>();
			for (InstourEntity instour : item.getInstours()) {
				if (instour.getStatus().equals("OPEN")) {
					InstourDTO instourDTO = instourConverter.toDTO(instour);
					listInstour.add(instourDTO);
				}
			}
			tourDTO.setInstours(listInstour);
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
	public List<TourDTO> findAllByRouteId(Long id) {
		List<TourDTO> models = new ArrayList<>();
		RouteEntity routeEntity = routeRepository.findOne(id);
		List<TourEntity> entities = tourRepository.findAllByRoute(routeEntity);
		for (TourEntity item : entities) {
			TourDTO tourDTO = tourConverter.toDTO(item);
			List<InstourDTO> listInstour = new ArrayList<>();
			for (InstourEntity instour : item.getInstours()) {
				InstourDTO instourDTO = instourConverter.toDTO(instour);
				listInstour.add(instourDTO);
			}
			tourDTO.setInstours(listInstour);
			models.add(tourDTO);
		}
		return models;
	}

	@Override
	public List<BookingDTO> revenueByMonth(String month, String year) {
		List<Object[]> revenueMonths = tourRepository.revenueByMonth(month, year);
		List<BookingDTO> bookingDTO = new ArrayList<>();
		for (Object[] revenue : revenueMonths) {
			BookingDTO b = new BookingDTO();
			b.setTourName((String) revenue[0]);
			b.setAdultPrice(((BigInteger) revenue[1]).longValue());
			b.setChildrenPrice(((BigInteger) revenue[2]).longValue());
			b.setAdultQuantity(((BigDecimal) revenue[3]).intValue());
			b.setChildrenQuantity(((BigDecimal) revenue[4]).intValue());
			bookingDTO.add(b);
		}
		return bookingDTO;
	}

	@Override
	public List<BookingDTO> numberTicketByMonth(String month, String year, Long routeId) {
		List<Object[]> numberTickets = tourRepository.numberTicketByMonth(month, year, routeId);
		List<BookingDTO> bookingDTO = new ArrayList<>();
		for (Object[] numberTicket : numberTickets) {
			BookingDTO b = new BookingDTO();
			b.setTourName((String) numberTicket[0]);
			b.setAdultQuantity(((BigDecimal) numberTicket[1]).intValue());
			b.setChildrenQuantity(((BigDecimal) numberTicket[2]).intValue());
			bookingDTO.add(b);
		}
		return bookingDTO;
	}

	@Override
	public int getTotalItem() {
		return (int) tourRepository.count();
	}

	@Override
	public TourDTO findById(long id) {
		TourDTO tourDTO;
		TourEntity entity = tourRepository.findOne(id);
		tourDTO = tourConverter.toDTO(entity);

		List<InstourDTO> listInstour = new ArrayList<>();
		for (InstourEntity item : entity.getInstours()) {
			InstourDTO instourDTO = instourConverter.toDTO(item);
			listInstour.add(instourDTO);
//			if (item.getStatus().equals("OPEN")) {
//				InstourDTO instourDTO = instourConverter.toDTO(item);
//				listInstour.add(instourDTO);
//			}
		}
		tourDTO.setInstours(listInstour);

		List<TourLocationDTO> listTourLocation = new ArrayList<>();
		for (TourLocationEntity item : entity.getLocations()) {
			TourLocationDTO tourLocationDTO = tourLocationConverter.toDTO(item);
			tourLocationDTO.setLocation(locationConverter.toDTO(item.getLocation()));
			listTourLocation.add(tourLocationDTO);
		}
		tourDTO.setTourLocations(listTourLocation);

		List<ReviewDTO> listReview = new ArrayList<>();
		for (ReviewEntity item : entity.getReviews()) {
			ReviewDTO reviewDTO = reviewConverter.toDTO(item);
			listReview.add(reviewDTO);
		}
		tourDTO.setReviews(listReview);

		return tourDTO;
	}

	@Override
	public TourDTO findByIdInTourPage(long id) {
		TourDTO tourDTO;
		TourEntity entity = tourRepository.findOne(id);
		tourDTO = tourConverter.toDTO(entity);

		List<InstourDTO> listInstour = new ArrayList<>();
		for (InstourEntity item : entity.getInstours()) {
			if (item.getStatus().equals("OPEN")) {
				InstourDTO instourDTO = instourConverter.toDTO(item);
				listInstour.add(instourDTO);
			}
		}
		tourDTO.setInstours(listInstour);

		List<TourLocationDTO> listTourLocation = new ArrayList<>();
		for (TourLocationEntity item : entity.getLocations()) {
			TourLocationDTO tourLocationDTO = tourLocationConverter.toDTO(item);
			tourLocationDTO.setLocation(locationConverter.toDTO(item.getLocation()));
			listTourLocation.add(tourLocationDTO);
		}
		tourDTO.setTourLocations(listTourLocation);

		List<ReviewDTO> listReview = new ArrayList<>();
		for (ReviewEntity item : entity.getReviews()) {
			ReviewDTO reviewDTO = reviewConverter.toDTO(item);
			listReview.add(reviewDTO);
		}
		tourDTO.setReviews(listReview);

		return tourDTO;
	}

	@Override
	public TourDTO save(TourDTO dto) {
		TourEntity tourEntity;

		if (dto.getBase64() != null) {
			// convert image from base64 to bytes and write image to root dir
			String imagePath = dto.getBase64().split(",")[1];
			byte[] decodeBase64 = Base64.getDecoder().decode(imagePath.getBytes());
			String uploadRootPath = context.getRealPath("template/upload/tour");
			uploadFileUtil.writeOrUpdate(decodeBase64, uploadRootPath, dto.getImage());
		}

		if (dto.getId() != null) {
			TourEntity oldTour = tourRepository.findOne(dto.getId());
			tourEntity = tourConverter.toEntity(oldTour, dto);
		} else {
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
		TourLocationEntity tourLocationEntity;
		TourEntity tourEntity = tourRepository.findOne(dto.getTourId());
		LocationEntity locationEntity = locationRepository.findOne(dto.getLocationId());
		tourLocationEntity = tourLocationRepository.findOneByTourAndLocation(tourEntity, locationEntity);

		if (tourLocationEntity == null) {
			tourLocationEntity = new TourLocationEntity();
			tourLocationEntity.setTour(tourEntity);
			tourLocationEntity.setLocation(locationEntity);
		}

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

	@Override
	public List<TourDTO> searchTourByFilter(Long routeId, Long minPrice, Long maxPrice, String startDate) {
		List<TourDTO> models = new ArrayList<>();
		List<TourEntity> entities = tourRepository.searchTourByFilter(routeId, minPrice, maxPrice, startDate);

		for (TourEntity item : entities) {
			TourDTO tourDTO = tourConverter.toDTO(item);
			List<InstourDTO> listInstour = new ArrayList<>();
			for (InstourEntity instour : item.getInstours()) {
				if (instour.getStatus().equals("OPEN")) {
					InstourDTO instourDTO = instourConverter.toDTO(instour);
					listInstour.add(instourDTO);
				}
			}
			tourDTO.setInstours(listInstour);
			models.add(tourDTO);
		}

		return models;
	}
}

package com.nqhtour.service;

import com.nqhtour.dto.ClientDTO;
import com.nqhtour.entity.TourEntity;

public interface IClientService {
	ClientDTO findById(long id);
	ClientDTO save(ClientDTO dto);
	boolean checkBookingExist(Long idClient, Long idTour);
	boolean booking(Long idClient, TourEntity tourEntity);
}

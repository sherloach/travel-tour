package com.nqhtour.service;

import com.nqhtour.dto.ClientDTO;
import com.nqhtour.entity.TourEntity;

public interface IClientService {
	ClientDTO findById(long id);
	ClientDTO findByEmail(String email);
	ClientDTO save(ClientDTO dto);
	boolean checkBookingExist(Long idClient, Long idTour);
	boolean booking(Long idClient, TourEntity tourEntity, int nuTickets);
}

package com.nqhtour.service;

import com.nqhtour.dto.ClientDTO;

public interface IClientService {
	ClientDTO findById(long id);
	ClientDTO save(ClientDTO dto);
	boolean checkBookingExist(Long idClient, Long idTour);
	void booking(Long idClient, Long idTour);
}

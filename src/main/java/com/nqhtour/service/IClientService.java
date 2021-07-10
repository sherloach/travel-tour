package com.nqhtour.service;

import com.nqhtour.dto.ClientDTO;
import com.nqhtour.dto.ClientTourDTO;
import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.TourEntity;

import javax.mail.MessagingException;
import java.util.List;

public interface IClientService {
	ClientDTO findById(long id);
	ClientDTO findByEmail(String email);
	ClientDTO save(ClientDTO dto);
	List<ClientTourDTO> myTour(String email);
	boolean checkBookingExist(Long idClient, Long idTour);
	void deleteTourBooking(ClientEntity client, Long idTour);
	boolean booking(Long idClient, TourEntity tourEntity, int nuTickets) throws MessagingException;
	String sendEmail(String email, int nuTickets, TourEntity tourEntity) throws MessagingException;
}

package com.nqhtour.service;

import com.nqhtour.dto.ClientDTO;
import com.nqhtour.entity.TourEntity;

import javax.mail.MessagingException;

public interface IClientService {
	ClientDTO findById(long id);
	ClientDTO findByEmail(String email);
	ClientDTO save(ClientDTO dto);
	boolean checkBookingExist(Long idClient, Long idTour);
	boolean booking(Long idClient, TourEntity tourEntity, int nuTickets) throws MessagingException;
	String sendEmail(String email, int nuTickets, TourEntity tourEntity) throws MessagingException;
}

package com.nqhtour.dto;

import java.util.ArrayList;
import java.util.List;

import com.nqhtour.entity.TourEntity;

public class ClientDTO extends AbstractDTO<ClientDTO> {
	private String name;
	private Long userID;
	private boolean gender;
	private String email;
	private String address;
	private String phoneNumber;
	private String username;
	private String password;
	private String role;
	private Integer status;
	private List<TourEntity> tours = new ArrayList<>();
	private List<BookingDTO> bookings = new ArrayList<>();

	public List<BookingDTO> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDTO> bookings) {
		this.bookings = bookings;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<TourEntity> getTours() {
		return tours;
	}
	public void setTours(List<TourEntity> tours) {
		this.tours = tours;
	}
	
}

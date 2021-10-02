package com.nqhtour.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "`client`")
public class ClientEntity extends BaseEntity {
	@Column
	private String name;

	@Column
	private boolean gender;

	@Column
	private String email;

	@Column
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@OneToMany(mappedBy = "client")
	private List<BookingEntity> bookings = new ArrayList<>();

	@OneToMany(mappedBy = "client")
	private List<ReviewEntity> reviews = new ArrayList<>();

//	@OneToMany(mappedBy = "tourEntity", fetch = FetchType.LAZY)
//	private List<ClientTourEntity> tours = new ArrayList<>();

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<BookingEntity> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingEntity> bookings) {
		this.bookings = bookings;
	}

	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

//	public List<ClientTourEntity> getTours() {
//		return tours;
//	}
//
//	public void setTours(List<ClientTourEntity> tours) {
//		this.tours = tours;
//	}
}


package com.nqhtour.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`employee`")
public class EmployeeEntity extends BaseEntity {
	@Column
	private String name;

	@Column
	private boolean gender;

	@Column
	private String email;

	@Column
	private String address;

	@Column(columnDefinition = "DATE")
	private String birthday;

	@Column
	private String phoneNumber;

	@Column(columnDefinition = "TEXT")
	private String avatar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@OneToMany(mappedBy = "guide")
	private List<InstourEntity> tours = new ArrayList<>();

	@OneToMany(mappedBy = "employee")
	private List<BookingEntity> bookings = new ArrayList<>();

//	@OneToMany(mappedBy = "employee")
//	private List<TourEntity> tour = new ArrayList<>();

	public String getName() {
		return name;
	}

	public List<InstourEntity> getTours() {
		return tours;
	}

	public void setTours(List<InstourEntity> tours) {
		this.tours = tours;
	}

	public List<BookingEntity> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingEntity> bookings) {
		this.bookings = bookings;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

//	public List<TourEntity> getTour() {
//		return tour;
//	}
//
//	public void setTour(List<TourEntity> tour) {
//		this.tour = tour;
//	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}


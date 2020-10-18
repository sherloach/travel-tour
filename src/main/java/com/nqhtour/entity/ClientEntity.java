package com.nqhtour.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity extends BaseEntity {
	@Column(name = "name", columnDefinition = "NVARCHAR")
	private String name;

	@Column(name = "gender")
	private boolean gender;

	@Column(name = "email")
	private String email;

	@Column(name = "address", columnDefinition = "NVARCHAR")
	private String address;

	@Column(name = "phonenumber")
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "booking", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "tour_id"))
	private List<TourEntity> tours = new ArrayList<>();

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

	public List<TourEntity> getTours() {
		return tours;
	}

	public void setTours(List<TourEntity> tours) {
		this.tours = tours;
	}
}


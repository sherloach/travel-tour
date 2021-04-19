package com.nqhtour.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "`client`")
public class ClientEntity extends BaseEntity {
	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private boolean gender;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "phonenumber")
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserEntity user;

	@OneToMany(mappedBy = "tourEntity", fetch = FetchType.LAZY)
	private List<ClientTourEntity> tours = new ArrayList<>();

	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "booking", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "tour_id"))
	private List<TourEntity> tours = new ArrayList<>();*/

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

	/*public List<TourEntity> getTours() {
		return tours;
	}*/

	/*public void setTours(List<TourEntity> tours) {
		this.tours = tours;
	}*/

	public List<ClientTourEntity> getTours() {
		return tours;
	}

	public void setTours(List<ClientTourEntity> tours) {
		this.tours = tours;
	}
}


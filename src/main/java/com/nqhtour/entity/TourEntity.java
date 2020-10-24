package com.nqhtour.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`tour`")
public class TourEntity extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@Column(name = "tourID")
	private String tourID;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "duration")
	private Integer duration;

	@Column(name = "maxgroupsize")
	private Integer maxGroupSize;
	
	@Column(name = "price")
	private Long price;

	@Column(name = "employeeid")
	private Long employeeID;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "summary")
	private String summary;

	@Column(name = "images", columnDefinition = "TEXT")
	private String images;

	@Column(name = "imagecover", columnDefinition = "TEXT")
	private String imageCover;
	
	@Column(name = "startdate")
	private Timestamp startDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employee;

	@ManyToMany(mappedBy = "tours")
	private List<ClientEntity> clients = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return tourID;
	}

	public void setSlug(String tourID) {
		this.tourID = tourID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getMaxGroupSize() {
		return maxGroupSize;
	}

	public void setMaxGroupSize(Integer maxGroupSize) {
		this.maxGroupSize = maxGroupSize;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getImageCover() {
		return imageCover;
	}

	public void setImageCover(String imageCover) {
		this.imageCover = imageCover;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
}

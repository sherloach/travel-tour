package com.nqhtour.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tour")
public class TourEntity extends BaseEntity {
	@Column(name = "name", columnDefinition = "NVARCHAR", length = 100)
	private String name;
	
	@Column(name = "slug")
	private String slug;
	
	@Column(name = "location", columnDefinition = "NVARCHAR", length = 255)
	private String location;
	
	@Column(name = "duration")
	private Integer duration;

	@Column(name = "maxgroupsize")
	private Integer maxGroupSize;
	
	@Column(name = "price")
	private Integer price;

	@Column(name = "guideid")
	private Long guideID;
	
	@Column(name = "employeeid")
	private Long employeeID;

	@Column(name = "description", columnDefinition = "NVARCHAR", length = 255)
	private String description;

	@Column(name = "summary", columnDefinition = "NVARCHAR", length = 255)
	private String summary;

	@Column(name = "images", columnDefinition = "TEXT")
	private String images;

	@Column(name = "imagecover", columnDefinition = "TEXT")
	private String imageCover;
	
	@Column(name = "startdate")
	private Timestamp startDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getGuideID() {
		return guideID;
	}

	public void setGuideID(Long guideID) {
		this.guideID = guideID;
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

package com.nqhtour.dto;

import java.sql.Timestamp;

public class TourDTO extends AbstractDTO<TourDTO> {
	private String name;
	private String slug;
	private String location;
	private Integer duration;
	private Integer maxGroupSize;
	private Long price;
	//private Long guideID;
	private Long employeeID;
	private String description;
	private String summary;
	private String images;
	private String imageCover;
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

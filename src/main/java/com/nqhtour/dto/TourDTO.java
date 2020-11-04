package com.nqhtour.dto;

public class TourDTO extends AbstractDTO<TourDTO> {
	private String name;
	private String tourID;
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
	private String startDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTourID() {
		return tourID;
	}
	public void setTourID(String slug) {
		this.tourID = slug;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}

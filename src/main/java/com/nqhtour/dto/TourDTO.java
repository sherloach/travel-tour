package com.nqhtour.dto;

import java.util.List;

public class TourDTO extends AbstractDTO<TourDTO> {
	private String name;
	private String tourID;
	private String location; // d
	private Integer duration;
	private Integer maxGroupSize;
	private Integer currentGroupSize; // d
	private Float ratingsAverage;
	private Integer ratingsQuantity;
	private String summary;
	private String description;
	private String image;
	private Long adultPrice;
	private Long childrenPrice;
	private Long price; // d
	private String createdBy;
	private Long employeeID; // d
	private String images; // d
	private String imageCover; // d
	private String base64;
	private String startDate; // d
	private Long routeId;
	private List<InstourDTO> instours;
	private List<TourLocationDTO> tourLocations;
	private String startLocation;
	private String destination;

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Float getRatingsAverage() {
		return ratingsAverage;
	}

	public void setRatingsAverage(Float ratingsAverage) {
		this.ratingsAverage = ratingsAverage;
	}

	public Integer getRatingsQuantity() {
		return ratingsQuantity;
	}

	public void setRatingsQuantity(Integer ratingsQuantity) {
		this.ratingsQuantity = ratingsQuantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(Long adultPrice) {
		this.adultPrice = adultPrice;
	}

	public Long getChildrenPrice() {
		return childrenPrice;
	}

	public void setChildrenPrice(Long childrenPrice) {
		this.childrenPrice = childrenPrice;
	}

	@Override
	public String getCreatedBy() {
		return createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public List<InstourDTO> getInstours() {
		return instours;
	}

	public void setInstours(List<InstourDTO> instours) {
		this.instours = instours;
	}

	public List<TourLocationDTO> getTourLocations() {
		return tourLocations;
	}

	public void setTourLocations(List<TourLocationDTO> tourLocations) {
		this.tourLocations = tourLocations;
	}

	public Integer getCurrentGroupSize() {
		return currentGroupSize;
	}

	public void setCurrentGroupSize(Integer curentGroupSize) {
		this.currentGroupSize = curentGroupSize;
	}

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
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
}

package com.nqhtour.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "`tour`")
@EntityListeners(AuditingEntityListener.class)
public class TourEntity extends BaseEntity {
	@Column
	private String name;

	@Column
	private String slug;

	@Column
	private Integer duration;

	@Column
	private Integer maxGroupSize;

	@Column
	private Float ratingsAverage;

	@Column
	private Integer ratingsQuantity;

	@Column
	private String summary;

	@Column
	private String description;

	@Column(columnDefinition = "TEXT")
	private String image;

	@Column
	private Long adultPrice;

	@Column
	private Long childrenPrice;

	@Column
	@CreatedBy
	private String createdBy;

	@ManyToOne
	@JoinColumn(name = "route_id")
	private RouteEntity route;

	@OneToMany(mappedBy = "tour")
	private List<InstourEntity> instours = new ArrayList<>();

	@OneToMany(mappedBy = "tour")
	private List<ReviewEntity> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "tour")
	private List<TourLocationEntity> locations = new ArrayList<>();

	public List<TourLocationEntity> getLocations() {
		return locations;
	}

	public void setLocations(List<TourLocationEntity> locations) {
		this.locations = locations;
	}

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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public RouteEntity getRoute() {
		return route;
	}

	public void setRoute(RouteEntity route) {
		this.route = route;
	}

	public List<InstourEntity> getInstours() {
		return instours;
	}

	public void setInstours(List<InstourEntity> instours) {
		this.instours = instours;
	}

	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}
}

package com.nqhtour.entity;

import javax.persistence.*;

@Entity
@Table(name = "tour_location")
public class TourLocationEntity {
    @EmbeddedId
    private TourLocationId tourLocationId = new TourLocationId();

    @ManyToOne
    @MapsId("locationId")
    @JoinColumn(name = "location_id")
    private LocationEntity location;

    @ManyToOne
    @MapsId("tourId")
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Integer day;

    public TourLocationId getTourLocationId() {
        return tourLocationId;
    }

    public void setTourLocationId(TourLocationId tourLocationId) {
        this.tourLocationId = tourLocationId;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}

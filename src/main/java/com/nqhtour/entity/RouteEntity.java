package com.nqhtour.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {
    @Column
    private String startLocation;

    @Column
    private String destination;

    @OneToMany(mappedBy = "route")
    private List<TourEntity> tours = new ArrayList<>();

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

    public List<TourEntity> getTours() {
        return tours;
    }

    public void setTours(List<TourEntity> tours) {
        this.tours = tours;
    }
}

package com.nqhtour.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TourLocationId implements Serializable {
    @Column(name = "tour_id")
    private Long tourId;

    @Column(name = "location_id")
    private Long locationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourLocationId that = (TourLocationId) o;
        return Objects.equals(tourId, that.tourId) && Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, locationId);
    }
}

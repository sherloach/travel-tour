package com.nqhtour.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instours")
@EntityListeners(AuditingEntityListener.class)
public class InstourEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    @ManyToOne
    @JoinColumn(name = "guide_id")
    private EmployeeEntity guide;

    @Column
    private Integer participants;

    @Column
    private String startDate;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    private String status;

    @OneToMany(mappedBy = "instour")
    private List<BookingEntity> bookings = new ArrayList<>();

    public List<BookingEntity> getTours() {
        return bookings;
    }

    public void setTours(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
    }

    public EmployeeEntity getGuide() {
        return guide;
    }

    public void setGuide(EmployeeEntity guide) {
        this.guide = guide;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

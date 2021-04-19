package com.nqhtour.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`booking`")
public class ClientTourEntity {

    @EmbeddedId
    private ClientTourId clientTourId = new ClientTourId();

    @ManyToOne
    @MapsId("clientID")
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    @ManyToOne
    @MapsId("tourID")
    @JoinColumn(name = "tour_id")
    private TourEntity tourEntity;

    @Column
    private Integer nuTickets;

    public ClientTourId getClientTourId() {
        return clientTourId;
    }

    public void setClientTourId(ClientTourId clientTourId) {
        this.clientTourId = clientTourId;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public TourEntity getTourEntity() {
        return tourEntity;
    }

    public void setTourEntity(TourEntity tourEntity) {
        this.tourEntity = tourEntity;
    }

    public Integer getNuTickets() {
        return nuTickets;
    }

    public void setNuTickets(Integer nuTickets) {
        this.nuTickets = nuTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientTourEntity that = (ClientTourEntity) o;
        return Objects.equals(clientTourId, that.clientTourId) && Objects.equals(clientEntity, that.clientEntity) && Objects.equals(tourEntity, that.tourEntity) && Objects.equals(nuTickets, that.nuTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientTourId, clientEntity, tourEntity, nuTickets);
    }
}

//package com.nqhtour.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class ClientTourId implements Serializable {
//
//    @Column(name = "client_id")
//    private Long clientID;
//
//    @Column(name = "tour_id")
//    private Long tourID;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ClientTourId that = (ClientTourId) o;
//        return Objects.equals(clientID, that.clientID) && Objects.equals(tourID, that.tourID);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(clientID, tourID);
//    }
//}

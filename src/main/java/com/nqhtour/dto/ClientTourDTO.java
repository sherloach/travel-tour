package com.nqhtour.dto;

import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.TourEntity;

import java.util.ArrayList;
import java.util.List;

public class ClientTourDTO {
    private TourEntity tourEntity;
    private Integer nuTickets;
    private List<ClientTourDTO> listResult = new ArrayList<>();

    public List<ClientTourDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<ClientTourDTO> listResult) {
        this.listResult = listResult;
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
}

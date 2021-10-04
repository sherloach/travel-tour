package com.nqhtour.dto;

public class RouteDTO extends AbstractDTO<RouteDTO> {
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
}

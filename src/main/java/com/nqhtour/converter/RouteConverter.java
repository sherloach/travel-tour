package com.nqhtour.converter;

import com.nqhtour.dto.RouteDTO;
import com.nqhtour.entity.RouteEntity;
import org.springframework.stereotype.Component;

@Component
public class RouteConverter {
    public RouteDTO toDTO(RouteEntity entity) {
        RouteDTO result = new RouteDTO();
        result.setId(entity.getId());
        result.setStartLocation(entity.getStartLocation());
        result.setDestination(entity.getDestination());

        return result;
    }

    public RouteEntity toEntity(RouteDTO dto) {
        RouteEntity result = new RouteEntity();
        result.setStartLocation(dto.getStartLocation());
        result.setDestination(dto.getDestination());

        return result;
    }
}

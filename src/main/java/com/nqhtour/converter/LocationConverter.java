package com.nqhtour.converter;

import com.nqhtour.dto.LocationDTO;
import com.nqhtour.entity.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter {
    public LocationDTO toDTO(LocationEntity entity) {
        LocationDTO result = new LocationDTO();
        result.setId(entity.getId());
        result.setAddress(entity.getAddress());
        result.setLatitude(entity.getLatitude());
        result.setLongitude(entity.getLongitude());
        result.setType(entity.getType());

        return result;
    }

    public LocationEntity toEntity(LocationDTO dto) {
        LocationEntity result = new LocationEntity();
        result.setAddress(dto.getAddress());
        result.setLatitude(dto.getLatitude());
        result.setLongitude(dto.getLongitude());

        return result;
    }
}

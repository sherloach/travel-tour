package com.nqhtour.service.impl;

import com.nqhtour.converter.LocationConverter;
import com.nqhtour.dto.LocationDTO;
import com.nqhtour.entity.LocationEntity;
import com.nqhtour.repository.LocationRepository;
import com.nqhtour.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService implements ILocationService {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationConverter locationConverter;

    @Override
    public List<LocationDTO> findAll() {
        List<LocationDTO> models = new ArrayList<>();
        List<LocationEntity> entities = locationRepository.findAll();
        for (LocationEntity item : entities) {
            LocationDTO locationDTO = locationConverter.toDTO(item);
            models.add(locationDTO);
        }
        return models;
    }

    @Override
    public LocationDTO save(LocationDTO dto) {
        LocationEntity locationEntity = locationConverter.toEntity(dto);
        locationEntity.setType("point");
        return locationConverter.toDTO(locationRepository.save(locationEntity));
    }

    @Override
    public void delete(long id) {

    }
}

package com.nqhtour.service;

import com.nqhtour.dto.LocationDTO;

import java.util.List;

public interface ILocationService {
    List<LocationDTO> findAll();
    LocationDTO save(LocationDTO dto);
    void delete(long id);
}

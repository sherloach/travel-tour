package com.nqhtour.service.impl;

import com.nqhtour.converter.RouteConverter;
import com.nqhtour.dto.RouteDTO;
import com.nqhtour.entity.RouteEntity;
import com.nqhtour.repository.RouteRepository;
import com.nqhtour.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService implements IRouteService {
    @Autowired
    RouteRepository routeRepository;

    @Autowired
    RouteConverter routeConverter;

    @Override
    public List<RouteDTO> findAll(Pageable pageable) {
        List<RouteDTO> models = new ArrayList<>();
        List<RouteEntity> entities = routeRepository.findAll(pageable).getContent();
        for (RouteEntity item : entities) {
            RouteDTO routeDTO = routeConverter.toDTO(item);
            models.add(routeDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) routeRepository.count();
    }

    @Override
    public RouteDTO findById(long id) {
        RouteEntity routeEntity = routeRepository.findOne(id);
        return routeConverter.toDTO(routeEntity);
    }

    @Override
    public RouteDTO save(RouteDTO dto) {
        RouteEntity routeEntity = routeConverter.toEntity(dto);
        return routeConverter.toDTO(routeRepository.save(routeEntity));
    }

    @Override
    public void delete(long id) {

    }
}

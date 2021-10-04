package com.nqhtour.service;

import com.nqhtour.dto.RouteDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRouteService {
    List<RouteDTO> findAll(Pageable pageable);
    int getTotalItem();
    RouteDTO findById(long id);
    RouteDTO save(RouteDTO dto);
    void delete(long id);
}

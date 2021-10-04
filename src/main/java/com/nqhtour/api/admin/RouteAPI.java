package com.nqhtour.api.admin;

import com.nqhtour.dto.RouteDTO;
import com.nqhtour.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController(value = "RouteAPIOfAdmin")
public class RouteAPI {
    @Autowired
    private IRouteService routeService;

    @GetMapping("/api/routes/{page}/{limit}")
    public RouteDTO readRoutes(@PathVariable int page, @PathVariable int limit) {
        RouteDTO routeDTO = new RouteDTO();
        Pageable pageable = new PageRequest(page - 1, limit);
        routeDTO.setListResult(routeService.findAll(pageable));

        return routeDTO;
    }

    @PostMapping("/api/route")
    public RouteDTO createRoute(@RequestBody RouteDTO route) {
        return routeService.save(route);
    }
}

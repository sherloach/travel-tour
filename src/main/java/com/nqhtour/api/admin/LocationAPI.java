package com.nqhtour.api.admin;

import com.nqhtour.dto.LocationDTO;
import com.nqhtour.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "LocationAPIOfAdmin")
public class LocationAPI {
    @Autowired
    ILocationService locationService;

    @PostMapping("/api/location")
    public LocationDTO createLocation(@RequestBody LocationDTO location) {
        return locationService.save(location);
    }
}

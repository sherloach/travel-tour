package com.nqhtour.api.admin;

import com.nqhtour.dto.LocationDTO;
import com.nqhtour.entity.LocationEntity;
import com.nqhtour.repository.LocationRepository;
import com.nqhtour.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "LocationAPIOfAdmin")
public class LocationAPI {
    @Autowired
    ILocationService locationService;

    @Autowired
    LocationRepository locationRepository;

    @PostMapping("/api/location")
    public LocationDTO createLocation(@RequestBody LocationDTO location) {
        return locationService.save(location);
    }

    @PostMapping("/api/location/check")
    public Boolean checkExistLocation(@RequestBody LocationDTO location) {
//        LocationEntity locationEntity1 = locationRepository.findByLatitudeAndLongitude(location.getLatitude(), location.getLongitude());
        LocationEntity locationEntity = locationRepository.findOneByAddress(location.getAddress());
        System.out.println("gg: " + locationEntity);
        if (locationEntity != null) {
            return true;
        }

        return false;
    }
}

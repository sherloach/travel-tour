package com.nqhtour.repository;

import com.nqhtour.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    LocationEntity findOneByLatitudeAndLongitude(Float latitude, Float longitude);
    LocationEntity findByLatitudeAndLongitude(Float latitude, Float longitude);
    LocationEntity findOneByAddress(String address);
}

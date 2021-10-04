package com.nqhtour.repository;

import com.nqhtour.entity.TourLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourLocationRepository extends JpaRepository<TourLocationEntity, Long> {
}

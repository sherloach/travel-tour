package com.nqhtour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nqhtour.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TourRepository extends JpaRepository<TourEntity, Long>, JpaSpecificationExecutor<TourEntity> {

}

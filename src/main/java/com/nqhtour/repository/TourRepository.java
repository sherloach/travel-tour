package com.nqhtour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nqhtour.entity.TourEntity;

public interface TourRepository extends JpaRepository<TourEntity, Long>{

}

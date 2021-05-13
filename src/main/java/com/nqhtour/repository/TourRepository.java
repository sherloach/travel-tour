package com.nqhtour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nqhtour.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<TourEntity, Long>, JpaSpecificationExecutor<TourEntity> {
    @Query(value = "call travelbooking.sp_hot_tours()", nativeQuery = true)
    List<TourEntity> findByHotTours();

    @Query(value = "call travelbooking.sp_new_tours()", nativeQuery = true)
    List<TourEntity> findByNewTours();
}

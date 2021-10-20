package com.nqhtour.repository;

import com.nqhtour.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nqhtour.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<TourEntity, Long>, JpaSpecificationExecutor<TourEntity> {
    List<TourEntity> findAllByRoute(RouteEntity routeEntity);

    @Query(value = "call travelbooking2.RevenueByMonth(?1,?2)", nativeQuery = true)
    List<Object[]> revenueByMonth(String month, String year);
//
//    @Query(value = "call travelbooking.sp_new_tours()", nativeQuery = true)
//    List<TourEntity> findByNewTours();
//
//    @Query(value = "call travelbooking.GetTopTourByMoney(?1,?2)", nativeQuery = true)
//    List<TourEntity> getByTopTourByMoney(String month,String year);
}

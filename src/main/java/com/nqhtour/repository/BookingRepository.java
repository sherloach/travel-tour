package com.nqhtour.repository;

import com.nqhtour.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    @Query(value = "call travelbooking2.CompleteStatus(?1)", nativeQuery = true)
    void completeBooking(Long instourId);

    @Procedure("CompleteStatus")
    void completeStatus(Long instourId);
}

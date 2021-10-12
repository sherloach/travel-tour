package com.nqhtour.repository;

import com.nqhtour.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
}

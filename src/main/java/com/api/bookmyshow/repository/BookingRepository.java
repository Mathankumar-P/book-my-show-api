package com.api.bookmyshow.repository;

import com.api.bookmyshow.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository <Booking, Long> {

}

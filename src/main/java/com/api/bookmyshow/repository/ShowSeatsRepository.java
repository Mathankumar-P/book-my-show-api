package com.api.bookmyshow.repository;

import com.api.bookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatsRepository extends JpaRepository <ShowSeat, Long>{
}

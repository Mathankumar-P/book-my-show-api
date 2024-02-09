package com.api.bookmyshow.repository;

import com.api.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie, Long>{
}

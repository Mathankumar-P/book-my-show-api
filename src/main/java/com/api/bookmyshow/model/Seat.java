package com.api.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

@Entity
public class Seat extends BaseModel{
    private  int seatNumber;
    private char rowNom;
    private int colNum;
    @Enumerated
    private SeatType seatType;
}

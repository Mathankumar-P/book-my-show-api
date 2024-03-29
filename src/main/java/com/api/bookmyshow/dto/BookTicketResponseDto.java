package com.api.bookmyshow.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BookTicketResponseDto {
    private Long bookingId;
    private double amount;
    private List<Integer> seatNumbers;
    private String theatreName;
}
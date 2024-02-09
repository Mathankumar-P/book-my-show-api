package com.api.bookmyshow.controller;

import com.api.bookmyshow.model.Booking;
import com.api.bookmyshow.service.BookingService;
import com.api.bookmyshow.dto.*;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    public final BookingService bookingService;

    @Autowired
    public TicketController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(path = "/book")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody BookTicketResponseDto bookTicket(@RequestBody BookTicketRequestDto requestDto) throws BadRequestException {

        System.out.println(requestDto);

        Booking booking = bookingService.bookMovie(requestDto.getShowSeatIds());
        return BookTicketResponseDto.builder()
                .bookingId(booking.getId())
                .amount(booking.getAmount())
                .theatreName(booking.getShow().getScreen().getTheater().getName())
                .build();
    }
}

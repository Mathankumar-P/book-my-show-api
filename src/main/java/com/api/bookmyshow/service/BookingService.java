package com.api.bookmyshow.service;

import com.api.bookmyshow.model.Booking;
import com.api.bookmyshow.model.Show;
import com.api.bookmyshow.model.ShowSeat;
import com.api.bookmyshow.model.ShowSeatStatus;
import com.api.bookmyshow.repository.BookingRepository;
import com.api.bookmyshow.repository.ShowSeatsRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    private final ShowSeatsRepository showSeatsRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(ShowSeatsRepository showSeatsRepository, BookingRepository bookingRepository) {
        this.showSeatsRepository = showSeatsRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(List<Long> showSeatIds) throws BadRequestException {

        List<ShowSeat> showSeats = showSeatsRepository.findAllById(showSeatIds);
        System.out.println(showSeats.isEmpty());
        if (showSeats.size() != showSeatIds.size()) {
            throw new BadRequestException();
        }


        for (ShowSeat showSeat: showSeats) {
            System.out.println(showSeat+" "+ showSeat.getShowSeatStatus());
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new BadRequestException("Seat not available.");
            }


            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);

        }
        showSeatsRepository.saveAll(showSeats);

        Show show = showSeats.get(0).getShow();
        Booking booking = Booking.builder()
                .bookedAt(new Date())
                .amount(12.0)
                .showSeatList(showSeats)
                .show(show)
                .build();

        bookingRepository.save(booking);

        return booking;
    }
}

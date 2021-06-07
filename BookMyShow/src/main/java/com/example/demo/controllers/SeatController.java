package com.example.demo.controllers;

import com.example.demo.model.request.SeatRequest;
import com.example.demo.model.entity.Seat;
import com.example.demo.model.response.SeatResponse;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController {

    @Autowired
    SeatRepository seatRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    BookingService bookingService;


    @PostMapping("/book/seat/show/{showId}/customer/{customerId}")
    public List<SeatResponse> createBooking(@RequestBody SeatRequest seats,
                                            @PathVariable("showId") Long showId, @PathVariable("customerId") Long customerId) {
      return bookingService.bookSeats(showId,seats.getId(),customerId);
    }

    @GetMapping("/display/seat/show/{showId}")
    public List<SeatResponse> displaySeat(@PathVariable("showId") Long showId) {
        return bookingService.displaySeats(showId);
    }
}

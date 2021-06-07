package com.example.demo.services;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.Seat;
import com.example.demo.model.entity.Show;
import com.example.demo.model.entity.Ticket;
import com.example.demo.model.internal.SeatStatus;
import com.example.demo.model.response.SeatResponse;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.mapper.SeatEntityToResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SeatEntityToResponseMapper seatEntityToResponseMapper;
    @Autowired
    TicketRepository ticketRepository;


    public List<SeatResponse> displaySeats(Long showId) {
        Optional<Show> show = showRepository.findById(showId);
        List<SeatResponse> seatResponses = new ArrayList<SeatResponse>();
         if (show.isPresent()) {
             List<Seat> showSeats = show.get().getSeats();
            for(Seat seat: showSeats){
                seatResponses.add(seatEntityToResponseMapper.apply(seat));
            }
        }
        return seatResponses;
    }

    public List<SeatResponse> bookSeats(Long showId, List<Long> seats, Long customerId) {
        Optional<Show> show = showRepository.findById(showId);
        Optional<Customer> customer = customerRepository.findById(customerId);
        List<SeatResponse> seatList = new ArrayList<SeatResponse>();

        if (show.isPresent()) {
            for (Long seatId : seats) {
                Optional<Seat> seat = seatRepository.findById(seatId);
                if (seat.get().getSeatStatus().toString().equalsIgnoreCase("BOOKED")) {
                    return null;
                }
            }
            for (Long seatId : seats) {
                Optional<Seat> seat = seatRepository.findById(seatId);
                Ticket ticket = new Ticket();
                ticket.setCustomer(customer.get());
                ticket.setSeat(seat.get());
                ticketRepository.save(ticket);
                seat.get().setSeatStatus(SeatStatus.BOOKED);
                seat.get().setCustomer(customer.get());
                seatList.add(seatEntityToResponseMapper.apply(seat.get()));
                seatRepository.save(seat.get());
            }
        }
        return seatList;
    }


}







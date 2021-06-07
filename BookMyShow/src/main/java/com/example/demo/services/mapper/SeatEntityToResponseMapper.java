package com.example.demo.services.mapper;

import com.example.demo.model.entity.Seat;
import com.example.demo.model.response.SeatResponse;
import org.springframework.stereotype.Component;

@Component
public class SeatEntityToResponseMapper {
    public SeatResponse apply(Seat seat){
        SeatResponse seatResponse = new SeatResponse();
        seatResponse.setId(seat.getSeatId());
        seatResponse.setPrice(seat.getPrice());
        seatResponse.setShowName(seat.getShow().getMovie().getMovieName());
        seatResponse.setAudiName(seat.getShow().getAuditorium().getAudiName());
        seatResponse.setCustomerName(seat.getCustomer().getUserName());
        seatResponse.setStatus(seat.getSeatStatus().toString());
        return seatResponse;
    }
}

package com.example.demo.services;

import com.example.demo.model.entity.*;
import com.example.demo.model.response.ShowResponse;
import com.example.demo.repository.*;
import com.example.demo.services.mapper.ShowEntityToResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    AuditoriumRepository auditoriumRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ShowEntityToResponseMapper showEntityToResponseMapper;


    public Show addShow(Show showMock , Long audiId, Long movieId){
        Optional<Auditorium> auditorium = auditoriumRepository.findById(audiId);
        Optional<Movie> movie = movieRepository.findById(movieId);
        Show show = new Show();
        show.setStartTime(showMock.getStartTime());
        show.setEndTime(showMock.getEndTime());
        long testId = 260;
        Optional<Customer> testCustomer = customerRepository.findById(testId);

        if(auditorium.isPresent() && movie.isPresent()){
            show.setAuditorium(auditorium.get());
            show.setMovie(movie.get());
            showRepository.save(show);
            List showSeats = new ArrayList<Seat>();
            //assign number of seats as mentioned in audi
            for (int i = 0; i <auditorium.get().getTotalSeats() ; i++) {
                Seat seat = new Seat();
                seat.setShow(show);
                seat.setCustomer(testCustomer.get());
                seatRepository.save(seat);
                showSeats.add(seat);
            }
            show.setSeats(showSeats);
            showRepository.save(show);
            auditorium.get().getShows().add(show);
            auditoriumRepository.save(auditorium.get());
             return null;
        }
        return null;
    }

    public List<ShowResponse> displayShows(Long theatreId){
        Optional<Theatre> theatre = theatreRepository.findById(theatreId);
        List shows = new ArrayList<ShowResponse>();
        if(theatre.isPresent()){
            for(Auditorium auditorium:theatre.get().getAuditoriums()){
                for(Show show: auditorium.getShows()){
                    shows.add(showEntityToResponseMapper.apply(show));
                }
            }
            return shows;
        }
        return null;
    }




}

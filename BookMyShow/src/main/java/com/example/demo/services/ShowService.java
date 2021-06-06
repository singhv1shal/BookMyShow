package com.example.demo.services;

import com.example.demo.model.entity.*;
import com.example.demo.repository.AuditoriumRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.repository.TheatreRepository;
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

    public Show addShow(Long audiId, Long movieId){
        Optional<Auditorium> auditorium = auditoriumRepository.findById(audiId);
        Optional<Movie> movie = movieRepository.findById(movieId);
        Show show = new Show(auditorium.get().getTotalSeats());
        if(auditorium.isPresent() && movie.isPresent()){
            show.setAuditorium(auditorium.get());
            show.setMovie(movie.get());

             showRepository.save(show);
             return null;
        }
        return null;
    }

    public List<Show> displayShows(Long theatreId){
        Optional<Theatre> theatre = theatreRepository.findById(theatreId);
        List<Show> shows = new ArrayList<Show>();
        if(theatre.isPresent()){
            for(Auditorium auditorium:theatre.get().getAuditoriums()){
                for(Show show: auditorium.getShows()){
                    shows.add(show);
                }
            }
            return shows;
        }
        return null;
    }




}

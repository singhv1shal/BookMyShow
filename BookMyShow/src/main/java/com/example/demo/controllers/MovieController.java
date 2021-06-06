package com.example.demo.controllers;

import com.example.demo.model.entity.Movie;
import com.example.demo.model.entity.Show;
import com.example.demo.model.entity.Theatre;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    MovieRepository movieRepository;
    @PostMapping("/create/movie/theatre/{theatreId}")
    public Movie createMovie(@RequestBody Movie movie,
                              @PathVariable("theatreId") Long theatreId) {
        Optional<Theatre>theatre = theatreRepository.findById(theatreId);
        if(theatre.isPresent()){
            theatre.get().getMovies().add(movie);
            theatreRepository.save(theatre.get());
            movie.getTheatres().add(theatre.get());
            try {
                movieRepository.save(movie);
            }
            catch(Exception e){
                System.out.println(e);
            }
            return null;
        }
        return null;
    }
}

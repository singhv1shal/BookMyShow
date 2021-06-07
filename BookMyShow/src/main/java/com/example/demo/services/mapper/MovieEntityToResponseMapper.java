package com.example.demo.services.mapper;

import com.example.demo.model.entity.Movie;
import com.example.demo.model.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieEntityToResponseMapper {

    @Autowired
    TheatreEntityToResponseMapper theatreEntityToResponseMapper;
    public MovieResponse apply(Movie movie){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setMovieName(movie.getMovieName());
        movieResponse.setDuration(movie.getDurationInMins());
        movieResponse.setLanguage(movie.getLanguage());
        movieResponse.setGenre(movie.getGenre().toString());
        movieResponse.setTheatres(movie.getTheatres().stream().map(theatre -> theatreEntityToResponseMapper.apply(theatre)).collect(Collectors.toList()));
        return movieResponse;
    }
}

package com.example.demo.controllers;

import com.example.demo.model.entity.*;
import com.example.demo.repository.AuditoriumRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/create/show/movie/{movieId}/audi/{audiId}")
    public Show createTheatre(@PathVariable("audiId") Long audiId,
                                 @PathVariable("movieId") Long movieId) {
     return showService.addShow(audiId, movieId);
    }
    @PostMapping("/show/display/theatre/{theatreId}")
    public List<Show> displayShows(@PathVariable("theatreId") Long theatreId) {
        return showService.displayShows(theatreId);
    }


}

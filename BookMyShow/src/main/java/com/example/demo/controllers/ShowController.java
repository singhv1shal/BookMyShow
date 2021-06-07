package com.example.demo.controllers;

import com.example.demo.model.entity.*;
import com.example.demo.model.response.ShowResponse;
import com.example.demo.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/create/show/movie/{movieId}/audi/{audiId}")
    public Show createTheatre(@RequestBody Show show , @PathVariable("audiId") Long audiId,
                                 @PathVariable("movieId") Long movieId) {
     return showService.addShow(show, audiId, movieId);
    }
    @GetMapping("/show/display/theatre/{theatreId}")
    public List<ShowResponse> displayShows(@PathVariable("theatreId") Long theatreId) {
        return showService.displayShows(theatreId);
    }


}

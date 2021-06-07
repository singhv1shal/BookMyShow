package com.example.demo.controllers;
import com.example.demo.model.entity.City;
import com.example.demo.model.entity.Movie;
import com.example.demo.model.response.CityResponse;
import com.example.demo.model.response.MovieResponse;
import com.example.demo.repository.CityRepository;
import com.example.demo.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;


@RestController
public class CityController {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    SearchService searchService;
    @PostMapping("/city/create")
    public City createCity(@RequestBody City city){
        return cityRepository.save(city);
    }


    @GetMapping("/city/display")
    public List<CityResponse> displayAllCities(){return searchService.findAllCities();}

    @GetMapping("/movie/display/city/{cityId}")
    public HashSet<MovieResponse> displayAllMovies(@PathVariable ("cityId") Long cityId){return searchService.findAllCityMovies(cityId);}

}

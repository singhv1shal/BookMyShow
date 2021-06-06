package com.example.demo.services;

import com.example.demo.model.entity.City;
import com.example.demo.model.entity.Movie;
import com.example.demo.model.entity.Theatre;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.TheatreOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    TheatreOwnerRepository theatreOwnerRepository;
    @Autowired
    CityRepository cityRepository;

    public List<City> findAllCities(){
        List<City>cities = cityRepository.findAll();
        List<City> result = new ArrayList<City>();
        for(City city: cities){
            if(city.getTheatres().size()!=0){
                result.add(city);
            }
        }
        return result;
    }

    public HashSet<Movie> findAllMovies(Long cityId){
        Optional<City> city = cityRepository.findById(cityId);
        HashSet<Movie> result = new HashSet<Movie>();
        if(city.isPresent()){
            List<Theatre>theatres = city.get().getTheatres();
            for(Theatre theatre: theatres){
                for(Movie movie: theatre.getMovies()){
                    result.add(movie);
                }
            }
            return result;
        }
        return null;
    }




}

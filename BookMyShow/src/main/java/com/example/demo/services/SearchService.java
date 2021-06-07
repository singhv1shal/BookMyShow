package com.example.demo.services;

import com.example.demo.model.entity.City;
import com.example.demo.model.entity.Movie;
import com.example.demo.model.entity.Theatre;
import com.example.demo.model.response.CityResponse;
import com.example.demo.model.response.MovieResponse;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.TheatreOwnerRepository;
import com.example.demo.services.mapper.CityEntityToResponseMapper;
import com.example.demo.services.mapper.MovieEntityToResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    CityEntityToResponseMapper cityEntityToResponseMapper;
    @Autowired
    MovieEntityToResponseMapper movieEntityToResponseMapper;

    public List<CityResponse> findAllCities(){
        List<City>cities = cityRepository.findAll();
        List result = new ArrayList<CityResponse>();
        for(City city: cities){
            if(city.getTheatres().size()!=0){
                result.add(cityEntityToResponseMapper.apply(city));
            }
        }
        return result;
    }

    public HashSet<MovieResponse> findAllCityMovies(Long cityId){
        Optional<City> city = cityRepository.findById(cityId);
        HashSet result = new HashSet<MovieResponse>();
        if(city.isPresent()) {
            List<Theatre> theatres = city.get().getTheatres();
            for (Theatre theatre : theatres) {
                List<Movie>movies = theatre.getMovies();
                for (Movie movie : movies) {
                    result.add(movieEntityToResponseMapper.apply(movie));
                }
            }
        }
            return result;

    }




}

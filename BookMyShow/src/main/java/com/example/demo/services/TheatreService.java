package com.example.demo.services;

import com.example.demo.model.entity.City;
import com.example.demo.model.entity.Movie;
import com.example.demo.model.entity.Theatre;
import com.example.demo.model.entity.TheatreOwner;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.TheatreOwnerRepository;
import com.example.demo.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {
    @Autowired
    TheatreOwnerRepository theatreOwnerRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    TheatreRepository theatreRepository;

    public Theatre addTheatre(Theatre theatre, Long ownerId, String cityName){
        Optional<TheatreOwner> owner = theatreOwnerRepository.findById(ownerId);
        Optional<City> city = cityRepository.findByCityName(cityName);
        City city1 = new City();
        if(!city.isPresent()) {
          city1.setCityName(cityName);
          cityRepository.save(city1);
        }
        if(owner.isPresent()){
            theatre.setTheatreOwner(owner.get());
            if(city.isPresent())
            theatre.setCity(city.get());
            else
            theatre.setCity(city1);
            theatreRepository.save(theatre);
            return theatre;
        }
        return null;
    }







}

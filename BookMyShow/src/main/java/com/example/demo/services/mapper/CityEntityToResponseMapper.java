package com.example.demo.services.mapper;

import com.example.demo.model.entity.City;
import com.example.demo.model.response.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityEntityToResponseMapper {
    @Autowired
    TheatreEntityToResponseMapper theatreEntityToResponseMapper;
    public CityResponse apply(City city){
        CityResponse cityResponse = new CityResponse();
        cityResponse.setId(city.getId());
        cityResponse.setCityName(city.getCityName());
        cityResponse.setTheatres(city.getTheatres().stream().map(theatre -> theatreEntityToResponseMapper.apply(theatre)).collect(Collectors.toList()));
        return cityResponse;
    }
}

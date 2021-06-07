package com.example.demo.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CityResponse {
    Long id;
    String cityName;
    List<TheatreResponse> theatres;

}

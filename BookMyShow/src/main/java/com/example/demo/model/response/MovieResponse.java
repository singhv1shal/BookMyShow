package com.example.demo.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class MovieResponse {
    Long id;
    String movieName;
    String language;
    int duration;
    String genre;
    List<TheatreResponse> theatres;
}

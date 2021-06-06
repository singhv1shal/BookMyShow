package com.example.demo.model.entity;

import com.example.demo.model.internal.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String movieName;
    private Genre genre;
    private int durationInMins;
    private String language;
    @OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Show> shows;
    @ManyToMany
    @JoinTable(
            name = "movie_theatre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "theatre_id"))
    private List<Theatre> theatres;


}

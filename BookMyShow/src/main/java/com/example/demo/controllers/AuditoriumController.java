package com.example.demo.controllers;

import com.example.demo.model.entity.Auditorium;
import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.Theatre;
import com.example.demo.repository.AuditoriumRepository;
import com.example.demo.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuditoriumController {

    @Autowired
    AuditoriumRepository auditoriumRepository;
    @Autowired
    TheatreRepository theatreRepository;

    @PostMapping("/auditorium/create/theatre/{theatreId}")
    public Auditorium createAudi(@RequestBody Auditorium auditorium,
                               @PathVariable ("theatreId") long theatreId){
        Optional<Theatre> theatre = theatreRepository.findById(theatreId);
        if(theatre.isPresent()){
            auditorium.setTheatre(theatre.get());
            auditoriumRepository.save(auditorium);

        }
        return null;
    }

}

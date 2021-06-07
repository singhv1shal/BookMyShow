package com.example.demo.services.mapper;

import com.example.demo.model.entity.Theatre;
import com.example.demo.model.response.TheatreResponse;
import org.springframework.stereotype.Component;

@Component
public class TheatreEntityToResponseMapper {

    public TheatreResponse apply(Theatre theatre){
        TheatreResponse theatreResponse = new TheatreResponse();
        theatreResponse.setId(theatre.getId());
        theatreResponse.setTheatreName(theatre.getTheatreName());
        return theatreResponse;
    }
}

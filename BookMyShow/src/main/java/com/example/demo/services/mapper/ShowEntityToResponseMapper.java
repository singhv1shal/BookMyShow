package com.example.demo.services.mapper;

import com.example.demo.model.entity.Show;
import com.example.demo.model.response.ShowResponse;
import org.springframework.stereotype.Component;

@Component
public class ShowEntityToResponseMapper {
    public ShowResponse apply(Show show){
        ShowResponse showResponse = new ShowResponse();
        showResponse.setId(show.getShowId());
        showResponse.setStartTime(show.getStartTime());
        showResponse.setEndTime(show.getEndTime());
        showResponse.setMovieName(show.getMovie().getMovieName());
        showResponse.setTheatreName(show.getAuditorium().getTheatre().getTheatreName());
        return showResponse;
    }
}

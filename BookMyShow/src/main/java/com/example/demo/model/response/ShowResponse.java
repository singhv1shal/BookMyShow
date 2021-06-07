package com.example.demo.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Data
public class ShowResponse {
    Long id;
    String movieName;
    String theatreName;
    Instant startTime;
    Instant endTime;
}

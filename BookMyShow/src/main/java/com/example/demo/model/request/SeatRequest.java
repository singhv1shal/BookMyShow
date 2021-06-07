package com.example.demo.model.request;

import com.example.demo.model.entity.Seat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class SeatRequest {
    private List<Long> id;
}

package com.example.demo.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SeatResponse {
    Long id;
    Double price;
    String showName;
    String audiName;
    String status;
    String customerName;
}

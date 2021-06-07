package com.example.demo.model.entity;

import com.example.demo.model.internal.SeatStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seatId;
    private SeatStatus seatStatus;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "show_id", nullable = true )
    private Show show;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;
    public Seat(){this.seatStatus = SeatStatus.AVAILABLE;
    this.price = 100.0;
    }

}

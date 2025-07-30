package com.substring.irctc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="booking_passengers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingPassenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne//here mapping booking entity and BookingPassenger entity
    @JoinColumn(name="booking_id")
    private Booking booking;

    private String name;

    private Integer age;

    private String gender;

    @ManyToOne
    private TrainSeat trainSeat;

    private String seatNumber;



}

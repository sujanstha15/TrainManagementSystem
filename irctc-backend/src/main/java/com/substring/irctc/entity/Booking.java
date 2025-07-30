package com.substring.irctc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //mappping booking with user
    @ManyToOne //user has many booking
    @JoinColumn(name="user_id")
    private User user;

    private String pnr;

    @ManyToOne
    @JoinColumn(name="train_schedule")
    private TrainSchedule trainSchedule;

    @ManyToOne
    @JoinColumn(name="source_station_id")
    private Station sourceStation;

    @ManyToOne
    @JoinColumn(name="destination_station_id")
    private Station destinationStation;

    private LocalDate journeyDate;

    private BigDecimal totalFare;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookingPassenger> passengers;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;



}

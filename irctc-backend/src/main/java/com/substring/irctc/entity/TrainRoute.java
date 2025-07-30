package com.substring.irctc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name="train_route")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //many train in one route
    @JoinColumn(name="train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name="station_id")
    private Station station;

    private Integer stationOrder;

    private LocalTime arrivalTime;

    private LocalTime departureTime;

    private Integer haltTime;

    private Integer distanceFromSource;
}

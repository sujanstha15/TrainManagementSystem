package com.substring.irctc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="train_seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="train_schedule_id")
    private TrainSchedule trainSchedule;

    @Enumerated(EnumType.STRING)
    private CoachType coachType;

    private Integer totalSeats;

    private Integer availableSeats;

    private Double price;

    private Integer trainSeatOrder;

    private Integer seatNumberToAssign;

    public boolean isChochFull(){
        return availableSeats<=0;
    }

    public boolean isSeatAvailable(int seatToBook){
        return seatToBook <= availableSeats;
    }

}

package com.substring.irctc.entity;

import com.substring.irctc.annotations.ValidPassword;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="trains")
public class Train {
    //so what are the properties of train?

    @Id
    private String trainNo;

     private String name;

//    @ValidPassword
//    private int coches;

    private String routeName;

    //parameterized constructor


    public Train(String trainNo, String name, String routeName) {
        this.trainNo = trainNo;
        this.name = name;
        this.routeName = routeName;
    }

    public Train(){

    }

    public @Pattern(regexp = "^[A-Za-z][A-Za-z -]* [A-Za-z]$\n", message = "Invalid train number. Only alphabets and hyphones are allowed") String getName() {
        return name;
    }

    public void setName(@Pattern(regexp = "^[A-Za-z][A-Za-z -]* [A-Za-z]$\n", message = "Invalid train number. Only alphabets and hyphones are allowed") String name) {
        this.name = name;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public @NotEmpty(message = "train number is required!!") @Size(min = 3, max = 20, message = "Invalid length of train no.") @Pattern(regexp = "^\\d+$", message = "Invalid no, train no contains only numbers") String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(@NotEmpty(message = "train number is required!!") @Size(min = 3, max = 20, message = "Invalid length of train no.") @Pattern(regexp = "^\\d+$", message = "Invalid no, train no contains only numbers") String trainNo) {
        this.trainNo = trainNo;
    }
}

package com.shubho.Ride.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private int id;
    private int userId;
    private String vehicleName;
    private String vehicleNumber;
    private final int totalSeats = 2;
    private int availableSeats = totalSeats;
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehilcleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}

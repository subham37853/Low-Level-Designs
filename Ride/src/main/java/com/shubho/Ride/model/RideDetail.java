package com.shubho.Ride.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RideDetail {
    private int driverId;
    private String driverName;
    private String origin;
    private String destination;
    private String vehicleName;
    private String vehicleNumber;
    private int availableSeats;
}

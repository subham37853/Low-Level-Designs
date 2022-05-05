package com.shubho.Ride.dto;

import com.shubho.Ride.model.RideDetail;
import com.shubho.Ride.model.User;
import com.shubho.Ride.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class UserToRideTransformation {
    public static List<RideDetail> transformUserToRide(User user) {
        List<Vehicle> vehicles = user.getVehicle();
        List<RideDetail> rideDetails = new ArrayList<>();
        vehicles.forEach(vehicle -> {
            rideDetails.add(new RideDetail(user.getId(), user.getName(), user.getOrigin(), user.getDestination(),
                    vehicle.getVehicleName(), vehicle.getVehicleNumber(), vehicle.getAvailableSeats()));
        });
        return rideDetails;
    }
}

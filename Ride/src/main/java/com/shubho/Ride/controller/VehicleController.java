package com.shubho.Ride.controller;

import com.shubho.Ride.model.Vehicle;
import com.shubho.Ride.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        this.vehicleService.addVehicle(vehicle);
    }
}

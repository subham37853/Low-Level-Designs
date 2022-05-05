package com.shubho.Ride.services;

import com.shubho.Ride.model.Vehicle;
import com.shubho.Ride.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public void addVehicle(Vehicle vehicle) {
        this.vehicleRepository.addVehicle(vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        this.vehicleRepository.updateVehicle(vehicle);
    }

    public void deleteVehicle(int id) {
        this.vehicleRepository.deleteVehicle(id);
    }

    public Vehicle findVehicleById(int id) {
        return this.vehicleRepository.findVehicleById(id);
    }

    public List<Vehicle> findAllVehicles() {
        return this.vehicleRepository.findAllVehicles();
    }
}

package com.shubho.Ride.repository;

import com.shubho.Ride.model.User;
import com.shubho.Ride.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository{
    @Autowired
    UserRepository userRepository;

    private List<Vehicle> vehicleDB = new ArrayList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        User user = this.userRepository.findUserById(vehicle.getUserId());
        user.getVehicle().add(vehicle);
        this.vehicleDB.add(vehicle);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        // remove old vehicle
        this.deleteVehicle(vehicle.getId());
        User user = this.userRepository.findUserById(vehicle.getUserId());
        // add new vehicle
        user.getVehicle().add(vehicle);
        this.vehicleDB.add(vehicle);

    }

    @Override
    public void deleteVehicle(int id) {
        Vehicle oldVehicle = this.findVehicleById(id);
        if (oldVehicle == null) return;
        User user = this.userRepository.findUserById(oldVehicle.getUserId());
        user.getVehicle().remove(oldVehicle);
        this.vehicleDB.remove(oldVehicle);
    }

    @Override
    public Vehicle findVehicleById(int id) {
        return this.vehicleDB.stream().filter(vehicle -> vehicle.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        return this.vehicleDB;
    }
}

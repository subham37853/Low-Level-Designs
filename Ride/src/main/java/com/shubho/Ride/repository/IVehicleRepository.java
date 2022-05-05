package com.shubho.Ride.repository;

import com.shubho.Ride.model.User;
import com.shubho.Ride.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    /**
     * This method is for adding the user to the DB
     * @param vehicle
     */
    public void addVehicle(Vehicle vehicle);

    /**
     * Method for updating the exisiting user in the DB.
     * @param vehicle
     */
    public void updateVehicle(Vehicle vehicle);

    /**
     * Method for deleting the user from the DB.
     * @param id
     */
    public void deleteVehicle(int id);

    /**
     * Finding the user by its id
     * @param id
     * @return
     */
    public Vehicle findVehicleById(int id);

    /**
     * Return the whole DB of Users
     * @return
     */
    public List<Vehicle> findAllVehicles();
}

package com.shubho.Ride.services;

import com.shubho.Ride.dto.UserToRideTransformation;
import com.shubho.Ride.model.RideDetail;
import com.shubho.Ride.model.User;
import com.shubho.Ride.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        this.userRepository.addUser(user);
    }

    public void updateUser(User user) {
        this.userRepository.updateUser(user);
    }

    public void deleteUser(int id) {
        this.userRepository.deleteUser(id);
    }

    public User findUserById(int id) {
        return this.userRepository.findUserById(id);
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAllUsers();
    }

    public List<RideDetail> offerRide(int id) {
        return UserToRideTransformation.transformUserToRide(this.findUserById(id));
    }
}

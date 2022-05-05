package com.shubho.Ride.controller;

import com.shubho.Ride.model.RideDetail;
import com.shubho.Ride.model.User;
import com.shubho.Ride.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        this.userService.addUser(user);
    }

    @GetMapping("/getUser/{id}")
    public User findUserById(@PathVariable("id") int id) {
        return this.userService.findUserById(id);
    }

    @GetMapping("/offerRide/{id}")
    public List<RideDetail> offerRide(@PathVariable("id") int id) {
        return this.userService.offerRide(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return this.userService.findAllUsers();
    }
}

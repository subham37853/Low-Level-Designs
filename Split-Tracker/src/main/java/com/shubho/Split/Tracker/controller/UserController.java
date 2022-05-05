package com.shubho.Split.Tracker.controller;

import com.shubho.Split.Tracker.model.OwnedMoney;
import com.shubho.Split.Tracker.model.User;
import com.shubho.Split.Tracker.services.UserService;
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

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }

    @GetMapping("/show/{id}")
    public List<OwnedMoney> showBorrowedAmountByUser(@PathVariable("id") long id) {
        return this.userService.showBorrowedAmountByUser(id);
    }
}

package com.shubho.Split.Tracker.repositories;

import com.shubho.Split.Tracker.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public User findUserById(long id) {
        for (User eachUser : this.users) {
            if (eachUser.getId() == id) {
                return eachUser;
            }
        }
        return null;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public List<User> getAllUsers() {
        return this.users;
    }
}

package com.shubho.Ride.repository;

import com.shubho.Ride.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    private List<User> userDB = new ArrayList<>();

    @Override
    public void addUser(User user) {
        this.userDB.add(user);
    }

    @Override
    public void updateUser(User user) {
        this.deleteUser(user.getId());
        this.userDB.add(user);
    }

    @Override
    public void deleteUser(int id) {
        User oldUser = this.findUserById(id);
        if (oldUser == null) return;
        this.userDB.remove(oldUser);
    }

    @Override
    public User findUserById(int id) {
        return this.userDB.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return this.userDB;
    }
}

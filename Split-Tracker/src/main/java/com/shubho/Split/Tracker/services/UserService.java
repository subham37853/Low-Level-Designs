package com.shubho.Split.Tracker.services;

import com.shubho.Split.Tracker.model.OwnedMoney;
import com.shubho.Split.Tracker.model.SplitType;
import com.shubho.Split.Tracker.model.User;
import com.shubho.Split.Tracker.repositories.UserRepository;
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
        User removableUser = this.userRepository.findUserById(user.getId());
        this.userRepository.removeUser(user);
        this.userRepository.addUser(user);
    }

    public void splitMoney(long userId, int amount, int i, List<User> users, SplitType splitType, List<Integer> values) {
        if (splitType == SplitType.PERCENT && checkValidPercentage(values)) {
            splitByPercentage(userId, amount, users, values);
        }
        else if (splitType == SplitType.EQUAL) {
            splitByEqual(userId, amount, users);
        }
        else {
            // TODO : Here I have to implement the Exact functionality.
        }
    }

    private void splitByEqual(long userId, int amount, List<User> users) {
        int n = users.size();
        for (int i = 0; i < n; i++) {
            boolean foundUser = false;
            User user = users.get(i);
            double totalAmount = (amount /(double)n);
            for (OwnedMoney owner : user.getOwners()) {
                if (owner.getUser().getId() == userId) {
                    owner.setAmount(owner.getAmount() + totalAmount);
                    foundUser = true;
                    break;
                }
            }
            if (!foundUser) {
                user.getOwners().add(new OwnedMoney(this.userRepository.findUserById(userId), totalAmount));
            }
        }
    }

    private boolean checkValidPercentage(List<Integer> values) {
        Integer sum = values.stream().reduce(0, Integer::sum);
        return sum == 100;
    }

    private void splitByPercentage(long userId, int amount, List<User> users, List<Integer> values) {
        int n = users.size();
        for (int i = 0; i < n; i++) {
            boolean foundUser = false;
            User user = users.get(i);
            int totalAmount = (amount * values.get(i)) / 100;
            for (OwnedMoney owner : user.getOwners()) {
                if (owner.getUser().getId() == userId) {
                    owner.setAmount(owner.getAmount() + totalAmount);
                    foundUser = true;
                    break;
                }
            }
            if (!foundUser) {
                user.getOwners().add(new OwnedMoney(this.userRepository.findUserById(userId), totalAmount));
            }
        }
    }

    public List<OwnedMoney> showBorrowedAmountByUser(long id) {
        User user = this.userRepository.findUserById(id);
        return user.getOwners();
    }

    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    public User findUserById(long id) {
        return this.userRepository.findUserById(id);
    }
}

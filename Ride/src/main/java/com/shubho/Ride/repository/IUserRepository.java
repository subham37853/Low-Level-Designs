package com.shubho.Ride.repository;

import com.shubho.Ride.model.User;

import java.util.List;

public interface IUserRepository {
    /**
     * This method is for adding the user to the DB
     * @param user
     */
    public void addUser(User user);

    /**
     * Method for updating the exisiting user in the DB.
     * @param user
     */
    public void updateUser(User user);

    /**
     * Method for deleting the user from the DB.
     * @param id
     */
    public void deleteUser(int id);

    /**
     * Finding the user by its id
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * Return the whole DB of Users
     * @return
     */
    public List<User> findAllUsers();

}

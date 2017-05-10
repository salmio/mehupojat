package fi.c5msiren.service;

import fi.c5msiren.model.User;

/**
 * Interface for user service
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
public interface UserService {

    /**
     * Method for saving a user
     *
     * @param user User to be saved
     */
    void save(User user);

    /**
     * Method for finding user by username
     *
     * @param username Username of the user
     * @return the user with the username
     */
    User findByUsername(String username);
}
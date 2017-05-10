package fi.c5msiren.service;

/**
 * Interface for security service
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
public interface SecurityService {

    /**
     * Method for finding logged in username
     *
     * @return Logged in username
     */
    String findLoggedInUsername();

    /**
     * Method for logging in automatically
     *
     * @param username Username of the user
     * @param password Password of the user
     */
    void autologin(String username, String password);
}
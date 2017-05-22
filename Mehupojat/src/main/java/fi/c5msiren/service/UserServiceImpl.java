package fi.c5msiren.service;

import fi.c5msiren.repository.UserRepository;
import fi.c5msiren.repository.RoleRepository;
import fi.c5msiren.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * This class acts as a service for user class
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Database attribute containing users
     */   
    @Autowired
    private UserRepository userRepository;

    /**
     * Database attribute containing roles
     */   
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Method for saving a user to database
     *
     * @param user User to be saved
     */
    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
        user.addRole(roleRepository.findByName("ROLE_CUSTOMER"));
        userRepository.save(user);
    }

    /**
     * Method for finding user by username
     *
     * @param username Username of the user
     * @return the user with the username
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
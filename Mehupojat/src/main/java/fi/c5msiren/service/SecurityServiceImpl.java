package fi.c5msiren.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * This class acts as a service for spring boot security
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
@Service
public class SecurityServiceImpl implements SecurityService{

    /**
     * Attribute containing manager for authentication
     */   
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Attribute containing service for userdetails
     */   
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Attribute containing logger for logging messages
     */   
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    /**
     * Method for finding logged in username
     *
     * @return Logged in username
     */
    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    /**
     * Method for logging in automatically
     *
     * @param username Username of the user
     * @param password Password of the user
     */
    @Override
    public void autologin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
        }
    }
}
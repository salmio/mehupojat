package fi.c5msiren.service;

import fi.c5msiren.model.Role;
import fi.c5msiren.model.User;
import fi.c5msiren.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * This class acts as a details service for user class
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    /**
     * Database attribute containing users
     */   
    @Autowired
    private UserRepository userRepository;

    /**
     * Method for creating UserDetails from a user
     *
     * @param username Username of the user
     * @return the userdetails object created from the user
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
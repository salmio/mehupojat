package fi.c5msiren.model;

import javax.persistence.*;
import java.util.*;

/**
 * Class represents an User entity in the database
 *
 * @author Oskari
 * @version 2017.4.12
 * @since 1.8
 */
@Entity
@Table(name = "user")
public class User {

    /* auto generated ID field for identifying entities */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /* Attribute containing username */
    private String username;

    /* Attribute containing password */
    private String password;

    /* Attribute containing password confirmation*/
    private String passwordConfirm;

    /* Attribute containing the user roles */
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet();

    /* Attribute containing a list of all users addresses */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    /**
     *
     * @param username Username to be set for user
     * @param password Password to be set for user
     * @param passwordConfirm password confirmation to be set for user
     * @param addresses Addresses to be set for user
     */
    public User(String username, String password, String passwordConfirm, List<Address> addresses) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.addresses = addresses;
    }

    /**
     *
     * @param username Username to be set for user
     * @param password Password to be set for user
     * @param passwordConfirm password confirmation to be set for user
     * @param role Role type to be set for user
     * @param addresses Addresses to be set for user
     */
    public User(String username, String password, String passwordConfirm, Role role, List<Address> addresses) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roles.add(role);
        this.addresses = addresses;
    }

    /**
     * Empty constructor for code requirements
     */
    public User() {
    }

    /**
     * Getter method for id
     *
     * @return current value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Getter method for username
     *
     * @return current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username
     *
     * @param username Username to be set as users username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method for password
     *
     * @return current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password
     * 
     * @param password value to be set as password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for password confirmation
     *
     * @return current value of password confirmation
     */
    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * Setter method for password
     * 
     * @param passwordConfirm value to be set as password confirmation
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * Getter method for roles
     *
     * @return current value of roles
     */
    public Set<Role> getRoles() {
        return roles;
    }
    /**
     * Setter method for roles
     * 
     * @param roles value to be set as roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    /**
     * Getter method for addresses
     * 
     * @return current list of addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Setter method for addresses
     * 
     * @param addresses list of addresses to set as new value
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    
}

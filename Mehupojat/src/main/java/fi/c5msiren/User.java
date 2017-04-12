package fi.c5msiren;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Class represents an User entity in the database
 *
 * @author Oskari
 * @version 2017.4.12
 * @since 1.8
 */
@Entity
public class User {

    /* auto generated ID field for identifying entities */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /* Attribute containing email */
    private String email;

    /* Attribute containing password */
    private String password;

    /* Attribute containing a list of all users addresses */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    /**
     *
     * @param email Email to be set for user
     * @param password Password to be set for user
     * @param addresses Addresses to be set for user
     */
    public User(String email, String password, List<Address> addresses) {
        this.email = email;
        this.password = password;
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
     * Getter method for email
     *
     * @return current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email
     *
     * @param email email to be set as users email
     */
    public void setEmail(String email) {
        this.email = email;
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

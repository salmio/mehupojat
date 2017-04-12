package fi.c5msiren;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class represents an address entity in the database
 * 
 * @author Oskari
 * @version 2017.4.12
 * @since 1.8
 */
@Entity
public class Address {

    /* auto generated ID field for identifying entities */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /* Attribute for user's addresses streetAddress */
    private String streetAddress;
    
    /* Attribute to hold user's addresses postal code */
    private int postalCode;
    
    /* Attribute for user's addresses town */
    private String town;
    
    /* Attribute for user's addresses country */
    private String country;

    
    /**
     * Constructor to initialize an Address entity
     * 
     * @param streetAddress streetAddress to be set
     * @param town town to be set
     * @param country country to be set
     * @param postalCode postalcode to be set
     */
    public Address(String streetAddress, String town, String country, int postalCode) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.town = town;
        this.country = country;
    }

    /**
     * Empty constructor for code requirements
     */
    public Address() {
    }

    /**
     * Getter method for id
     * @return current value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Getter method for streetaddress
     * @return current value of streetaddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Setter method for streetaddress
     * 
     * @param streetAddress to be set as new value
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    
    /**
     * Getter method for postalCode
     * 
     * @return current value of postalcode
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Setter method for postalcode
     * 
     * @param postalCode postalcode value to be set as new postalcode
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

  
    /**
     * Getter method for town
     * 
     * @return current value of town
     */
    public String getTown() {
        return town;
    }

    
    /**
     * Setter method for town
     * 
     * @param town new value of town
     */
    public void setTown(String town) {
        this.town = town;
    }

    
    /**
     * Getter method for country
     * @return Current value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter method for country
     * 
     * @param country value of country to set as new
     */
    public void setCountry(String country) {
        this.country = country;
    }

}

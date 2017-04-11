package fi.c5msiren;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Oskari
 */
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String streetAddress;
    private int postalCode;
    private String town;
    private String country;

    public Address(String streetAddress, String town, String country, int postalCode) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.town = town;
        this.country = country;
    }
    
    

    public Address() {}
    
    public long getId() {
        return id;
    }

  
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetName(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}

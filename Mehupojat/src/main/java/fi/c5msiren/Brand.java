package fi.c5msiren;

import javax.persistence.*;

/**
 * Class represents an Brand entity in the database
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
@Entity
public class Brand {

    /* auto generated ID field for identifying entities */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    /* Attribute containing the name of the brand */
    private String name;

    /**
     * Empty constructor for code requirements
     */
    public Brand() {}
    
    /**
     *
     * @param name Name for the brand
     */
    public Brand(String name) {
        this.name = name;
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
     * Getter method for name
     *
     * @return current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name
     *
     * @param name Name to be set as brands name
     */
    public void setName(String name) {
        this.name = name;
    }
}
package fi.c5msiren.model;

import javax.persistence.*;
import java.util.*;

/**
 * Class represents an Category entity in the database
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
@Entity
public class Category {

    /* auto generated ID field for identifying entities */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    /* Attribute containing the name of the category */
    private String name;

    /**
     * Empty constructor for code requirements
     */
    public Category() {}
    
    /**
     *
     * @param name Name for the category
     */
    public Category(String name) {
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
     * @param name Name to be set as categorys name
     */
    public void setName(String name) {
        this.name = name;
    }

}
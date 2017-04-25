package fi.c5msiren;

import javax.persistence.*;
import java.util.*;

/**
 * Class represents an Product entity in the database
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
@Entity
public class Product {

    /* auto generated ID field for identifying entities */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    /* Attribute containing the name of the product */
    private String name;

    /* Attribute containing the price of the product */
    private double price;

    /* Attribute containing the description of the product */
    private String description;

    /* Reference to the brand of the product */
    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;

    /* List of the product categories */
    @ManyToMany
    private List<Category> categories;

    /**
     * Empty constructor for code requirements
     */
    public Product() {}
    
    /**
     *
     * @param name Name for the product
     * @param price Price for the product
     * @param description Description for the product
     */
    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     *
     * @param name Name for the product
     * @param price Price for the product
     * @param description Description for the product
     * @param brand Products brand
     */
    public Product(String name, double price, String description, Brand brand) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
    }

    /**
     *
     * @param name Name for the product
     * @param price Price for the product
     * @param description Description for the product
     * @param brand Products brand
     * @param categories List of all the product categories
     */
    public Product(String name, double price, String description, Brand brand, List<Category> categories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.categories = categories;
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
     * @param name Name to be set as products name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for price
     *
     * @return current value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for price
     *
     * @param price Price to be set as products price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter method for description
     *
     * @return current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description
     *
     * @param description Description to be set as products description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for brand
     *
     * @return current value of brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Setter method for brand
     *
     * @param brand Brand to be set as products brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Getter method for categories
     *
     * @return current list of categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Setter method for categories
     *
     * @param categories Categories to be set as products categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
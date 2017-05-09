package fi.c5msiren.model;

import javax.persistence.*;

/**
 * Class represents an Ingredient entity in the database
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
@Entity
public class Ingredient {

    /* auto generated ID field for identifying entities */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    /* Attribute containing the amount of the ingredient */
    private double amount;

    /* Attribute containing the unit of the ingredient */
    private String unit;

    /**
     * Empty constructor for code requirements
     */
    public Ingredient() {}
    
    /**
     *
     * @param amount Amount for the ingredient
     * @param unit Unit for the ingredient amount
     */
    public Ingredient(double amount, String unit) {
        this.amount = amount;
        this.unit = unit;
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
     * Getter method for amount
     *
     * @return current amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter method for amount
     *
     * @param amount Ingredient amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter method for unit
     *
     * @return unit of ingredient amount
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Setter method for unit
     *
     * @param unit Unit of ingredient amount
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
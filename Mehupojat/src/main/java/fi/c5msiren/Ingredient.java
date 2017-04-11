package fi.c5msiren;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private double amount;
    private String unit;

    public Ingredient() {}
    
    public Ingredient(double amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
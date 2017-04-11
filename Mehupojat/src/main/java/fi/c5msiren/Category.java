package fi.c5msiren;

import javax.persistence.*;
import java.util.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;

    public Category() {}
    
    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
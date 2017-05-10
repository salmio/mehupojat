package fi.c5msiren.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Class represents an Role entity in the database
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
@Entity
@Table(name = "role")
public class Role {

    /* auto generated ID field for identifying entities */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /* Attribute containing the name of the role */
    private String name;

    /* Attribute containing the users of the role */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    /**
     *
     * @param name Name for the role
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Empty constructor for code requirements
     */
    public Role() {
    }

    /**
     * Getter method for id
     *
     * @return current value of id
     */
    public Long getId() {
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
     * @param name Name to be set as roles name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for users
     *
     * @return current value of users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Setter method for name
     *
     * @param users Users to be set as roles users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
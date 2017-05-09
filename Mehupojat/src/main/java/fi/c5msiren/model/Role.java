package fi.c5msiren.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

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

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
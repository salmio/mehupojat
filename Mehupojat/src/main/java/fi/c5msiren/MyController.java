package fi.c5msiren;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

// This class acts as a controller.
// Usually when using @Controller, you will use also @RequestMapping
// mvn compile
// mvn spring-boot:run
@RestController
public class MyController {

    @Autowired
    private ProductRepository products;

    @Autowired
    private BrandRepository brands;

    @Autowired
    private CategoryRepository categories;

    /**
     * Database attribute containing users
     */    
    @Autowired
    private UserRepository users;

    // curl -H "Content-type: application/json" -X POST http://localhost:8080/products -d "{\"name\": \"Testi01\", \"price\": 42.0, \"description\": \"Kuvaus\", \"brand\": \"http://localhost:8080/brands/1\"}"
    @RequestMapping(value = "/products",  method=RequestMethod.POST)
    public void saveProductLocation(@RequestBody Product l) {
        products.save(l);
    }

    @RequestMapping(value = "/products",  method=RequestMethod.GET)
    public Iterable<Product> fetchProductLocation() {
        return products.findAll();
    }

    @RequestMapping(value = "/products/{id}",  method=RequestMethod.GET)
    public Product fetchProductLocation(@PathVariable long id) {
        return products.findById(id);
    }
    
    /**
     * Method to delete a product from the database
     * 
     * @param id id of product to delete
     */
    @RequestMapping(value = "/products/{id}",  method=RequestMethod.DELETE)
    public void deleteProduct(@PathVariable long id) {
        products.delete(id);
    }
    

    //curl -H "Content-type: application/json" -X POST http://localhost:8080/brands -d "{\"name\": \"BrandNimi\"}"
    @RequestMapping(value = "/brands",  method=RequestMethod.POST)
    public void saveBrandLocation(@RequestBody Brand b) {
        brands.save(b);
    }

    @RequestMapping(value = "/brands",  method=RequestMethod.GET)
    public Iterable<Brand> fetchBrandLocation() {
        return brands.findAll();
    }

    @RequestMapping(value = "/brands/{id}",  method=RequestMethod.GET)
    public Brand fetchBrandLocation(@PathVariable long id) {
        return brands.findById(id);
    }

    @RequestMapping(value = "/categories",  method=RequestMethod.POST)
    public void saveCategoryLocation(@RequestBody Category c) {
        categories.save(c);
    }

    @RequestMapping(value = "/categories",  method=RequestMethod.GET)
    public Iterable<Category> fetchCategoryLocation() {
        return categories.findAll();
    }

    @RequestMapping(value = "/categories/{id}",  method=RequestMethod.GET)
    public Category fetchCategoryLocation(@PathVariable long id) {
        return categories.findById(id);
    }
    
    
    
     //  curl -H "Content-type: application/json" -X POST http://localhos80/users -d "{\"password\": \"testipw\", \"email\": \"testi@email.com\", \"addresses\": [{\"streetAddress\":\"kolmaskatu\",\"town\":\"Helsinki\",\"country\":\"Finland\",\"postalCode\":272}] }"
    /**
     * Method to add an user to the database
     * 
     * @param user user in json form to add to database
     */
    @RequestMapping(value = "/users",  method=RequestMethod.POST)
    public void saveUser(@RequestBody User user) {
        users.save(user);
    }
    
    
    /**
     * Method to get all users from database
     * 
     * @return list of all users from database
     */
    @RequestMapping(value = "/users",  method=RequestMethod.GET)
    public Iterable<User> fetchAllUsers() {
        return users.findAll();
    }
    
    /**
     * Method for getting a single user out of database
     * 
     * @param id id of user to get
     * @return corresponding User from database
     */
    @RequestMapping(value = "/users/{id}",  method=RequestMethod.GET)
    public User fetchSingleUser(@PathVariable long id) {
        return users.findById(id);
    }
    
    /**
     * Method for deleting an user from the databse
     * 
     * @param id id of the user to delete
     */
    @RequestMapping(value = "/users/{id}",  method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) {
        users.delete(id);
    }
    
}
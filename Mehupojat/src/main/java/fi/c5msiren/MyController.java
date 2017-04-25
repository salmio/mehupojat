package fi.c5msiren;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class acts as a controller
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
@RestController
public class MyController {

    /**
     * Database attribute containing products
     */   
    @Autowired
    private ProductRepository products;

    /**
     * Database attribute containing brands
     */   
    @Autowired
    private BrandRepository brands;

    /**
     * Database attribute containing categories
     */   
    @Autowired
    private CategoryRepository categories;

    /**
     * Database attribute containing users
     */    
    @Autowired
    private UserRepository users;

    // curl -H "Content-type: application/json" -X POST http://localhost:8080/products -d "{\"name\": \"Testi01\", \"price\": 42.0, \"description\": \"Kuvaus\", \"brand\": \"http://localhost:8080/brands/1\"}"
    /**
     * Method to save a product to the database
     * 
     * @param p Product to be added to database
     */
    @RequestMapping(value = "/products",  method=RequestMethod.POST)
    public void saveProduct(@RequestBody Product p) {
        products.save(p);
    }

    /**
     * Method to fetch all products from the database
     */
    @RequestMapping(value = "/products",  method=RequestMethod.GET)
    public Iterable<Product> fetchProduct() {
        return products.findAll();
    }

    /**
     * Method to fetch a product from the database
     * 
     * @param id id of product to fetch
     */
    @RequestMapping(value = "/products/{id}",  method=RequestMethod.GET)
    public Product fetchProduct(@PathVariable long id) {
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

    /**
     * Method to update a product in the database
     * 
     * @param id id of product to update
     */
    @RequestMapping(value = "/products/{id}/update",  method=RequestMethod.POST)
    public void updateProduct(@PathVariable long id, @RequestBody Product newProduct) {
        Product oldProduct = products.findById(id);
        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setBrand(newProduct.getBrand());
        oldProduct.setCategories(newProduct.getCategories());
        products.save(oldProduct);
    }
    

    //curl -H "Content-type: application/json" -X POST http://localhost:8080/brands -d "{\"name\": \"BrandNimi\"}"
    /**
     * Method to save a brand to the database
     * 
     * @param b Brand to be added to database
     */
    @RequestMapping(value = "/brands",  method=RequestMethod.POST)
    public void saveBrand(@RequestBody Brand b) {
        brands.save(b);
    }

    /**
     * Method to fetch all brands from the database
     */
    @RequestMapping(value = "/brands",  method=RequestMethod.GET)
    public Iterable<Brand> fetchBrand() {
        return brands.findAll();
    }

    /**
     * Method to fetch a brand from the database
     * 
     * @param id id of brand to fetch
     */
    @RequestMapping(value = "/brands/{id}",  method=RequestMethod.GET)
    public Brand fetchBrand(@PathVariable long id) {
        return brands.findById(id);
    }

    /**
     * Method to save a category to the database
     * 
     * @param c Category to be added to database
     */
    @RequestMapping(value = "/categories",  method=RequestMethod.POST)
    public void saveCategory(@RequestBody Category c) {
        categories.save(c);
    }

    /**
     * Method to fetch all categories from the database
     */
    @RequestMapping(value = "/categories",  method=RequestMethod.GET)
    public Iterable<Category> fetchCategory() {
        return categories.findAll();
    }

    /**
     * Method to fetch a category from the database
     * 
     * @param id id of category to fetch
     */
    @RequestMapping(value = "/categories/{id}",  method=RequestMethod.GET)
    public Category fetchCategory(@PathVariable long id) {
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
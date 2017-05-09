package fi.c5msiren;

import fi.c5msiren.model.User;
import fi.c5msiren.model.Role;
import fi.c5msiren.model.Product;
import fi.c5msiren.model.Category;
import fi.c5msiren.model.Brand;
import fi.c5msiren.model.Address;
import fi.c5msiren.repository.AddressRepository;
import fi.c5msiren.repository.BrandRepository;
import fi.c5msiren.repository.CategoryRepository;
import fi.c5msiren.repository.ProductRepository;
import fi.c5msiren.repository.RoleRepository;
import fi.c5msiren.repository.UserRepository;
import org.h2.server.web.WebServlet;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import java.util.*;

/**
 * Class for starting the application
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer  implements CommandLineRunner {

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

    /**
     * Database attribute containing roles
     */   
    @Autowired
    private RoleRepository roles;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    /**
     * Starts the spring application
     *
     * @param args not used
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Inputs data to the embedded database at the start
     *
     * @param strings not used
     */
    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        Category categoryA = new Category("Tuorepuristettu");
        Category categoryB = new Category("Omatekoinen");
        categories.save(categoryA);
        categories.save(categoryB);

        List<Category> categoryListOne = new ArrayList<Category>();
        List<Category> categoryListTwo = new ArrayList<Category>();
        categoryListOne.add(categoryA);
        categoryListTwo.add(categoryA);
        categoryListTwo.add(categoryB);

        Brand brandA = new Brand("Kokis");
        Brand brandB = new Brand("Pepsi");
        brands.save(brandA);
        brands.save(brandB);

        Product productA = new Product("Omenamehu", 2.50, "Omenamehun kuvaus", "http://koti.tamk.fi/~c5msiren/Mehupojat/apple_juice.png", brandA);
        Product productB = new Product("Banaanimehu", 3.20, "Banaanimehun kuvaus", "http://koti.tamk.fi/~c5msiren/Mehupojat/banana_juice.jpg", brandB);
        Product productC = new Product("Appelsiinimehu", 4.00, "Appelsiinimehun kuvaus", "http://koti.tamk.fi/~c5msiren/Mehupojat/orange_juice.jpg", brandB);
        Product productD = new Product("Omenamehu #2", 2.70, "Omenamehun kuvaus", "http://koti.tamk.fi/~c5msiren/Mehupojat/apple_juice.png", brandB);
        Product productE = new Product("Banaanimehu #2", 3.50, "Banaanimehun kuvaus", "http://koti.tamk.fi/~c5msiren/Mehupojat/banana_juice.jpg", brandB);
        Product productF = new Product("Appelsiinimehu #2", 4.50, "Appelsiinimehun kuvaus", "http://koti.tamk.fi/~c5msiren/Mehupojat/orange_juice.jpg", brandB);
        Product productG = new Product("Omenamehu #3", 3.50, "Omenamehun kuvaus", "http://koti.tamk.fi/~c5msiren/Mehupojat/apple_juice.png", brandB);
        Product productH = new Product("Banaanimehu #3", 2.50, "Banaanimehun kuvaus", "http://koti.tamk.fi/~c5msiren/Mehupojat/banana_juice.jpg", brandB);

        productA.setCategories(categoryListOne);
        productB.setCategories(categoryListTwo);
        products.save(productA);
        products.save(productB);
        products.save(productC);
        products.save(productD);
        products.save(productE);
        products.save(productF);
        products.save(productG);
        products.save(productH);

        List<Address> addressListA = new ArrayList<>();
        List<Address> addressListB = new ArrayList<>();
        List<Address> addressListC = new ArrayList<>();

        Address addressA = new Address("Alakatu", "Helsinki", "Finland", 420);
        Address addressB = new Address("toinenkatu", "Trauma", "Kuusamo", 66666);
        Address addressC = new Address("Alakatu", "Helsinki", "Finland", 23899);

        addressListA.add(addressA);
        addressListA.add(addressB);
        addressListB.add(addressB);
        addressListC.add(addressC);

        Role roleA = new Role("CUSTOMER");
        Role roleB = new Role("ADMIN");
        roles.save(roleA);
        roles.save(roleB);

        User userA = new User("test@email.com", "kalapoliisi", "kalapoliisi", addressListA);
        User userB = new User("lintumies@hotmale.com", "pyykko", "pyykko", addressListB);
        User userC = new User("enthusiast@luukku.com", "yuotila", "yuotila", addressListC);
        users.save(userA);
        users.save(userB);
        users.save(userC);
    }

    //localhost:8080/console JDBC URL: jdbc:h2:mem:testdb
    /**
     * Creates site to connect to embedded database
     * 
     * @return created bean
     */
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}

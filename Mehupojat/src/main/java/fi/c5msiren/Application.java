package fi.c5msiren;

import org.h2.server.web.WebServlet;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

/**
 * Class for starting the application
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

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

        Product productA = new Product("Tuote 1", 42.00, "Tuotteen yksi kuvaus", "tempURL", brandA);
        Product productB = new Product("Tuote 2", 53.00, "Tuotteen kaksi kuvaus", "tempURL", brandB);
        Product productC = new Product("Tuote 3", 64.00, "Tuotteen kolme kuvaus", "tempURL", brandB);
        productA.setCategories(categoryListOne);
        productB.setCategories(categoryListTwo);
        products.save(productA);
        products.save(productB);
        products.save(productC);

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

        User userA = new User("test@email.com", "kalapoliisi", addressListA);
        User userB = new User("lintumies@hotmale.com", "pyykko", addressListB);
        User userC = new User("enthusiast@luukku.com", "yuotila", addressListC);
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

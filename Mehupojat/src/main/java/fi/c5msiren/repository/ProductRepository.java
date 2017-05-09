package fi.c5msiren.repository;

import fi.c5msiren.model.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Interface for product repository
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * Method for finding product with id
     *
     * @param id value of the id to find
     */
    Product findById(long id);
}
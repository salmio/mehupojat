package fi.c5msiren.repository;

import fi.c5msiren.model.Brand;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Interface for brands repository
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
public interface BrandRepository extends CrudRepository<Brand, Long> {

    /**
     * Method for finding brand with id
     *
     * @param id value of the id to find
     */
    Brand findById(long id);
}
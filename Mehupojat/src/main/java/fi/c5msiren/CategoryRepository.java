package fi.c5msiren;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Interface for category repository
 *
 * @author Miika
 * @version 2017.4.12
 * @since 1.8
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    /**
     * Method for finding category with id
     *
     * @param id value of the id to find
     */
    Category findById(long id);
}
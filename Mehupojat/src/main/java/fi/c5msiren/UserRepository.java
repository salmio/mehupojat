package fi.c5msiren;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


/**
 *  Class acting as a database for holding User -entities
 * 
 * @author Oskari
 * @version 2017.4.12
 * @since 1.8
 */
public interface UserRepository extends CrudRepository<User, Long> {
    
    /**
     * Custom method declaration for finding a single user by id
     * 
     * @param id id value which to find by
     * @return found user corresponding id
     */
    User findById(long id);
}

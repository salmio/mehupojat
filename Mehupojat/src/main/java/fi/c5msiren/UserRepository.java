package fi.c5msiren;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
/**
 *
 * @author Oskari
 */




public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
}

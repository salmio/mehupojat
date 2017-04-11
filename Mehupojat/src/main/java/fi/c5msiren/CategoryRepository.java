package fi.c5msiren;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findById(long id);
}
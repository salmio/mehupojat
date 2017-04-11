package fi.c5msiren;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Long> {
    Brand findById(long id);
}
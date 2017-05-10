package fi.c5msiren.repository;

import fi.c5msiren.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for roles repository
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
}
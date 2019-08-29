package autoservice.app.repositories;

import autoservice.app.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
}

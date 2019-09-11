package autoservice.app.employee;

import autoservice.app.employee.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Employee save(Employee entity);
}

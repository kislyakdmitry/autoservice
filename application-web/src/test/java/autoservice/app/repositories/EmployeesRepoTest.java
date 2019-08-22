package autoservice.app.repositories;

import autoservice.app.domain.Employee;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import autoservice.app.TestEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeesRepoTest extends GenericCrudRepoTest<EmployeeRepo, Employee, Long> {
    @Autowired
    private TestEntityFactory testEntityFactory;

    @Override
    public Employee getEntity() {
        return testEntityFactory.getEmployee();
    }

    @Override
    protected Employee updateEntity(Employee entity) {
        Employee updatedEntity = testEntityFactory.getUpdatedEmployee();
        updatedEntity.setId(entity.getId());
        return updatedEntity;
    }
}

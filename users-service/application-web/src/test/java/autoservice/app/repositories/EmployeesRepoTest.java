package autoservice.app.repositories;

import autoservice.app.TestEntityFactory;
import autoservice.app.domain.Employee;
import autoservice.app.repositories.generic.GenericCrudRepoTest;

public class EmployeesRepoTest extends GenericCrudRepoTest<EmployeeRepo, Employee, Long> {

    private static final String TEST_USERNAME = "epm1";
    private static final String TEST_PASSWORD = "pass";
    private static final String TEST_FIRST_NAME = "Daenerys";
    private static final String TEST_LAST_NAME = "Targaryen";

    private static final String TEST_UPDATED_USERNAME = "epm2";
    private static final String TEST_UPDATED_PASSWORD = "pass2";
    private static final String TEST_UPDATED_FIRST_NAME = "Tyrion";
    private static final String TEST_UPDATED_LAST_NAME = "Lannister";

    @Override
    public Employee getEntity() {
        return TestEntityFactory.getEmployee(TEST_USERNAME, TEST_PASSWORD, TEST_FIRST_NAME, TEST_LAST_NAME);
    }

    @Override
    protected Employee updateEntity(Employee entity) {
        Employee updatedEntity = TestEntityFactory.getEmployee(
                TEST_UPDATED_USERNAME,
                TEST_UPDATED_PASSWORD,
                TEST_UPDATED_FIRST_NAME,
                TEST_UPDATED_LAST_NAME);
        updatedEntity.setId(entity.getId());
        return updatedEntity;
    }
}

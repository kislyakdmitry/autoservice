package autoservice.app.repositories;

import autoservice.app.domain.*;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;


public class ContractsRepoTest extends GenericCrudRepoTest<ContractsRepo, Contract, Long> {
    @Autowired
    private CustomersRepo customersRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CarsRepo carsRepo;

    private static final LocalDateTime TEST_START_TIME = LocalDateTime.now();
    private static final LocalDateTime TEST_END_TIME = LocalDateTime.now();
    private static final LocalDateTime TEST_UPDATED_START_TIME = LocalDateTime.now().minusYears(1);
    private static final LocalDateTime TEST_UPDATED_END_TIME = LocalDateTime.now().minusYears(1);
    private static final Customer TEST_CUSTOMER = new Customer();
    private static final Customer TEST_UPDATED_CUSTOMER = new Customer();
    private static final Employee TEST_EMPLOYEE = new Employee();
    private static final Employee TEST_UPDATED_EMPLOYEE = new Employee();
    private static final Car TEST_CAR = new Car();
    private static final Car TEST_UPDATED_CAR = new Car();

    static {
        TEST_CUSTOMER.setUsername("customer");
        TEST_CUSTOMER.setPassword("password");
        TEST_CUSTOMER.setFirstName("Jon");
        TEST_CUSTOMER.setLastName("Snow");
        TEST_CUSTOMER.setRole(Role.CUSTOMER);
        TEST_UPDATED_CUSTOMER.setUsername("customer007");
        TEST_UPDATED_CUSTOMER.setPassword("password123");
        TEST_UPDATED_CUSTOMER.setFirstName("Ned");
        TEST_UPDATED_CUSTOMER.setLastName("Stark");
        TEST_UPDATED_CUSTOMER.setRole(Role.CUSTOMER);

        TEST_EMPLOYEE.setUsername("customer");
        TEST_EMPLOYEE.setPassword("password");
        TEST_EMPLOYEE.setFirstName("Jon");
        TEST_EMPLOYEE.setLastName("Snow");
        TEST_EMPLOYEE.setRole(Role.EMPLOYEE);
        TEST_UPDATED_EMPLOYEE.setUsername("customer007");
        TEST_UPDATED_EMPLOYEE.setPassword("password123");
        TEST_UPDATED_EMPLOYEE.setFirstName("Ned");
        TEST_UPDATED_EMPLOYEE.setLastName("Stark");
        TEST_UPDATED_EMPLOYEE.setRole(Role.EMPLOYEE);

        TEST_CAR.setName("UAZ");
        TEST_CAR.setPrice(BigDecimal.valueOf(100));
        TEST_CAR.setOrdered(true);
        TEST_UPDATED_CAR.setName("BMW");
        TEST_UPDATED_CAR.setPrice(BigDecimal.valueOf(1000));
        TEST_UPDATED_CAR.setOrdered(false);
    }

    @Override
    public Contract getEntity() {
        Contract contract = new Contract();
        contract.setStartTime(TEST_START_TIME);
        contract.setEndTime(TEST_END_TIME);
        contract.setCustomer(customersRepo.save(TEST_CUSTOMER));
        contract.setEmployee(employeeRepo.save(TEST_EMPLOYEE));
        contract.setCars(Collections.singletonList(carsRepo.save(TEST_CAR)));
        return contract;
    }

    @Override
    protected Contract updateEntity(Contract entity) {
        entity.setStartTime(TEST_UPDATED_START_TIME);
        entity.setEndTime(TEST_UPDATED_END_TIME);
        entity.setCustomer(customersRepo.save(TEST_CUSTOMER));
        entity.setEmployee(employeeRepo.save(TEST_EMPLOYEE));
        entity.setCars(Collections.singletonList(carsRepo.save(TEST_CAR)));
        return entity;
    }
}

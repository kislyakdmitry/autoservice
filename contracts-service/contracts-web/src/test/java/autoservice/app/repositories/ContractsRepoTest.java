package autoservice.app.repositories;

import autoservice.app.TestEntityFactory;
import autoservice.app.domain.Contract;
import autoservice.app.domain.Customer;
import autoservice.app.domain.Employee;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;


public class ContractsRepoTest extends GenericCrudRepoTest<ContractsRepo, Contract, Long> {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CustomersRepo customersRepo;

    @Autowired
    private ContractsRepo contractsRepo;

    private static final LocalDateTime TEST_START_TIME = LocalDateTime.now();
    private static final LocalDateTime TEST_UPDATED_START_TIME = LocalDateTime.now().minusYears(1);

    private static final LocalDateTime TEST_END_TIME = LocalDateTime.now();
    private static final LocalDateTime TEST_UPDATED_END_TIME = LocalDateTime.now().minusYears(1);

    private static final Customer TEST_CUSTOMER = TestEntityFactory.getCustomer("Jon", "Snow");
    private static final Customer TEST_UPDATED_CUSTOMER = TestEntityFactory.getCustomer("Ned", "Stark");

    private static final Employee TEST_EMPLOYEE = TestEntityFactory.getEmployee("epm1", "pass", "Daenerys", "Targaryen");
    private static final Employee TEST_UPDATED_EMPLOYEE = TestEntityFactory.getEmployee("epm2", "pass2", "Tyrion", "Lannister");

    private static final String TEST_CAR = "4USBT53544LT26841";
    private static final String TEST_UPDATED_CAR = "KL1UF756E6B195928";

    @Override
    public Contract getEntity() {
        return TestEntityFactory.getContract(
                TEST_START_TIME,
                TEST_END_TIME,
                customersRepo.save(TEST_CUSTOMER),
                employeeRepo.save(TEST_EMPLOYEE),
                Collections.singletonList(TEST_CAR));
    }

    @Override
    protected Contract updateEntity(Contract entity) {
        Contract updatedContract = TestEntityFactory.getContract(
                TEST_UPDATED_START_TIME,
                TEST_UPDATED_END_TIME,
                customersRepo.save(TEST_UPDATED_CUSTOMER),
                employeeRepo.save(TEST_UPDATED_EMPLOYEE),
                Collections.singletonList(TEST_UPDATED_CAR));
        updatedContract.setId(entity.getId());
        return updatedContract;
    }
}

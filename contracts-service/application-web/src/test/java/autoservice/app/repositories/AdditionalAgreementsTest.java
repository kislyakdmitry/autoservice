package autoservice.app.repositories;

import autoservice.app.TestEntityFactory;
import autoservice.app.domain.*;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

public class AdditionalAgreementsTest extends GenericCrudRepoTest<AdditionalAgreementsRepo, AdditionalAgreement, Long> {

    @Autowired
    private CarsRepo carsRepo;

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
    private static final Car TEST_CAR = TestEntityFactory.getCar("UAZ", BigDecimal.valueOf(1000));
    private static final Car TEST_UPDATED_CAR = TestEntityFactory.getCar("BMW", BigDecimal.valueOf(1500));

    @Override
    public AdditionalAgreement getEntity() {
        Contract contract = TestEntityFactory.getContract(
                TEST_START_TIME,
                TEST_END_TIME,
                customersRepo.save(TEST_CUSTOMER),
                employeeRepo.save(TEST_EMPLOYEE),
                Collections.singletonList(carsRepo.save(TEST_CAR)));
        return TestEntityFactory.getAdditionalAgreement(contractsRepo.save(contract), carsRepo.save(TEST_CAR));
    }

    @Override
    protected AdditionalAgreement updateEntity(AdditionalAgreement entity) {

        Contract contract = TestEntityFactory.getContract(
                TEST_UPDATED_START_TIME,
                TEST_UPDATED_END_TIME,
                customersRepo.save(TEST_UPDATED_CUSTOMER),
                employeeRepo.save(TEST_UPDATED_EMPLOYEE),
                Collections.singletonList(carsRepo.save(TEST_UPDATED_CAR)));

        AdditionalAgreement updatedAgreement = TestEntityFactory.getAdditionalAgreement(
                contractsRepo.save(contract),
                carsRepo.save(TEST_UPDATED_CAR));

        updatedAgreement.setId(entity.getId());
        return updatedAgreement;
    }
}

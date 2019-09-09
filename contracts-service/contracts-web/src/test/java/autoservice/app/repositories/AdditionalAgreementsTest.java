package autoservice.app.repositories;

import autoservice.app.TestEntityFactory;
import autoservice.app.domain.*;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

public class AdditionalAgreementsTest extends GenericCrudRepoTest<AdditionalAgreementsRepo, AdditionalAgreement, Long> {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CustomersRepo customersRepo;

    @Autowired
    private ContractsRepo contractsRepo;

    @Autowired
    private CarsRepo carsRepo;

    private static final LocalDate TEST_START_TIME = LocalDate.now();
    private static final LocalDate TEST_UPDATED_START_TIME = LocalDate.now().minusYears(1);
    private static final LocalDate TEST_END_TIME = LocalDate.now();
    private static final LocalDate TEST_UPDATED_END_TIME = LocalDate.now().minusYears(1);
    private static final Customer TEST_CUSTOMER = TestEntityFactory.getCustomer("Jon", "Snow");
    private static final Customer TEST_UPDATED_CUSTOMER = TestEntityFactory.getCustomer("Ned", "Stark");
    private static final Employee TEST_EMPLOYEE = TestEntityFactory.getEmployee("epm1", "pass", "Daenerys", "Targaryen");
    private static final Employee TEST_UPDATED_EMPLOYEE = TestEntityFactory.getEmployee("epm2", "pass2", "Tyrion", "Lannister");
    private static final Car TEST_CAR = TestEntityFactory.getCar("UAZ", BigDecimal.valueOf(1000), "vin", true);
    private static final Car TEST_UPDATED_CAR = TestEntityFactory.getCar("BMW", BigDecimal.valueOf(1234), "vin_new", false);


    @Override
    public AdditionalAgreement getEntity() {
        TEST_CAR.setVin(UUID.randomUUID().toString());
        Car car = carsRepo.save(TEST_CAR);
        Contract contract = TestEntityFactory.getContract(
                TEST_START_TIME,
                TEST_END_TIME,
                customersRepo.save(TEST_CUSTOMER),
                employeeRepo.save(TEST_EMPLOYEE),
                Collections.singletonList(car));
        return TestEntityFactory.getAdditionalAgreement(contractsRepo.save(contract), car);
    }

    @Override
    protected AdditionalAgreement updateEntity(AdditionalAgreement entity) {
        Car car = carsRepo.save(TEST_UPDATED_CAR);
        Contract contract = TestEntityFactory.getContract(
                TEST_UPDATED_START_TIME,
                TEST_UPDATED_END_TIME,
                customersRepo.save(TEST_UPDATED_CUSTOMER),
                employeeRepo.save(TEST_UPDATED_EMPLOYEE),
                Collections.singletonList(car));

        AdditionalAgreement updatedAgreement = TestEntityFactory.getAdditionalAgreement(
                contractsRepo.save(contract),
                car);
        updatedAgreement.setId(entity.getId());
        return updatedAgreement;
    }
}

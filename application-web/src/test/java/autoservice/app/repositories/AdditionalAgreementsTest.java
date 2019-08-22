package autoservice.app.repositories;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionalAgreementsTest extends GenericCrudRepoTest<AdditionalAgreementsRepo, AdditionalAgreement, Long> {

    @Autowired
    private CarsRepo carsRepo;

    @Autowired
    private ContractsRepo contractsRepo;

    public AdditionalAgreementsTest(CarsRepo carsRepo, ContractsRepo contractsRepo) {
        this.carsRepo = carsRepo;
        this.contractsRepo = contractsRepo;
    }

    @Override
    public AdditionalAgreement getEntity() {
        return new AdditionalAgreement();
    }

    @Override
    protected AdditionalAgreement updateEntity(AdditionalAgreement entity) {

        return null;
    }
}

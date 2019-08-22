package autoservice.app.repositories;

import autoservice.app.TestEntityFactory;
import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionalAgreementsTest extends GenericCrudRepoTest<AdditionalAgreementsRepo, AdditionalAgreement, Long> {

    @Autowired
    private TestEntityFactory testEntityFactory;

    @Override
    public AdditionalAgreement getEntity() {
        return testEntityFactory.getAdditionalAgreement();
    }

    @Override
    protected AdditionalAgreement updateEntity(AdditionalAgreement entity) {
        AdditionalAgreement updatedAgreement = testEntityFactory.getUpdatedAdditionalAgreement();
        updatedAgreement.setId(entity.getId());
        return updatedAgreement;
    }
}

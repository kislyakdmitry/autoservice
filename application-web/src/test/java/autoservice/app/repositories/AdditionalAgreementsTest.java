package autoservice.app.repositories;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.repositories.generic.GenericCrudRepoTest;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionalAgreementsTest extends GenericCrudRepoTest<AdditionalAgreementsRepo, AdditionalAgreement> {
    @Override
    public AdditionalAgreement getEntity() {
        return new AdditionalAgreement();
    }

    @Override
    public void testUpdate() {

        AdditionalAgreement agreement = new AdditionalAgreement();
        super.getRepository().save(agreement);

        AdditionalAgreement updatedAgreement = super.getRepository().save(agreement);

        assertThat(agreement).isEqualTo(updatedAgreement);
    }
}

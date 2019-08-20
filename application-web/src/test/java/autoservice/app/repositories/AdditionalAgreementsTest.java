package autoservice.app.repositories;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.domain.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class AdditionalAgreementsTest {

    @Autowired
    private AdditionalAgreementsRepo agreementsRepo;

    private Long generatedAgreementId;
    private Car testCar = new Car();

    @Before
    public void setUp() {
        AdditionalAgreement additionalAgreement = new AdditionalAgreement();
        testCar.setId(1L);
        additionalAgreement.setCar(testCar);
        generatedAgreementId = agreementsRepo.save(additionalAgreement).getId();
    }

    @Test
    public void testRead() {
        List<AdditionalAgreement> additionalAgreements = (List<AdditionalAgreement>) agreementsRepo.findAll();
        assertThat(additionalAgreements).isNotEmpty();

        AdditionalAgreement additionalAgreement = agreementsRepo.findById(generatedAgreementId).get();
        assertThat(additionalAgreement.getCar()).isEqualTo(testCar);
    }

    @Test
    public void testUpdate() {
        Car newCar = new Car();
        newCar.setId(2L);
        AdditionalAgreement additionalAgreement = agreementsRepo.findById(generatedAgreementId).get();
        additionalAgreement.setCar(newCar);
        agreementsRepo.save(additionalAgreement);
        AdditionalAgreement updatedAdditionalAgreement = agreementsRepo.findById(generatedAgreementId).get();
        assertThat(updatedAdditionalAgreement.getCar()).isEqualTo(newCar);
    }

    @Test
    public void testDelete() {
        agreementsRepo.deleteById(generatedAgreementId);
        Optional<AdditionalAgreement> additionalAgreement = agreementsRepo.findById(generatedAgreementId);
        assertThat(additionalAgreement.isPresent()).isFalse();
    }

}

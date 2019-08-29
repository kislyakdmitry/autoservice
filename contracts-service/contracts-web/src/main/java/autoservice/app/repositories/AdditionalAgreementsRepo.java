package autoservice.app.repositories;

import autoservice.app.domain.AdditionalAgreement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalAgreementsRepo extends CrudRepository<AdditionalAgreement, Long> {
}

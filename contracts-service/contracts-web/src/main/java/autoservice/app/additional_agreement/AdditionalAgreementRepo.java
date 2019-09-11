package autoservice.app.additional_agreement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalAgreementRepo extends CrudRepository<AdditionalAgreement, Long> {
}

package autoservice.app.additional_agreement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalAgreementRepo extends CrudRepository<AdditionalAgreement, Long> {
    List<AdditionalAgreement> findAdditionalAgreementsByContract_Id(Long contractId);
}

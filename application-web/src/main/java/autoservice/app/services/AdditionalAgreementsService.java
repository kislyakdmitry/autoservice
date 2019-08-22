package autoservice.app.services;

import autoservice.app.domain.AdditionalAgreement;

import java.util.List;
import java.util.Optional;

public interface AdditionalAgreementsService {
    AdditionalAgreement getAdditionalAgreementById(Long id);
    List<AdditionalAgreement> getAllAdditionalAgreements();
    AdditionalAgreement save(AdditionalAgreement additionalAgreement);
}

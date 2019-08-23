package autoservice.app.services;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.dto.AdditionalAgreementDto;

import java.util.List;

public interface AdditionalAgreementsService {
    AdditionalAgreement getAdditionalAgreementById(Long id);
    List<AdditionalAgreement> getAllAdditionalAgreements();
    AdditionalAgreement save(AdditionalAgreementDto dto);
}

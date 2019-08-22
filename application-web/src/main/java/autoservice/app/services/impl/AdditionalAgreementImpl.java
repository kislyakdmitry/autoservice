package autoservice.app.services.impl;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.exceptions.AdditionalAgreementNotFound;
import autoservice.app.repositories.AdditionalAgreementsRepo;
import autoservice.app.services.AdditionalAgreementsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdditionalAgreementImpl implements AdditionalAgreementsService {

    private AdditionalAgreementsRepo agreementsRepo;

    @Override
    public AdditionalAgreement getAdditionalAgreementById(Long id) {
        return agreementsRepo.findById(id)
                .orElseThrow(() -> new AdditionalAgreementNotFound("Additional agreement " + id + " not found"));
    }

    @Override
    public List<AdditionalAgreement> getAllAdditionalAgreements() {
        return (List<AdditionalAgreement>) agreementsRepo.findAll();
    }

    @Override
    public AdditionalAgreement save(AdditionalAgreement additionalAgreement) {
        return agreementsRepo.save(additionalAgreement);
    }
}

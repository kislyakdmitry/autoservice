package autoservice.app.services.impl;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.dto.AdditionalAgreementDto;
import autoservice.app.exceptions.AdditionalAgreementNotFound;
import autoservice.app.mappers.AgreementMapper;
import autoservice.app.repositories.AdditionalAgreementsRepo;
import autoservice.app.services.AdditionalAgreementsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalAgreementImpl implements AdditionalAgreementsService {

    private AdditionalAgreementsRepo agreementsRepo;
    private AgreementMapper agreementMapper;

    public AdditionalAgreementImpl(AdditionalAgreementsRepo agreementsRepo, AgreementMapper agreementMapper) {
        this.agreementsRepo = agreementsRepo;
        this.agreementMapper = agreementMapper;
    }

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
    public AdditionalAgreement save(AdditionalAgreementDto dto) {
        return agreementsRepo.save(agreementMapper.toAdditionalAgreement(dto));
    }
}

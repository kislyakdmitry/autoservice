package autoservice.app.additional_agreement;

import autoservice.app.additional_agreement.dto.AdditionalAgreementDto;
import autoservice.app.additional_agreement.exceptions.AdditionalAgreementNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalAgreementService {

    private AdditionalAgreementRepo agreementRepo;
    private AdditionalAgreementMapper agreementMapper;

    public AdditionalAgreementService(AdditionalAgreementRepo agreementRepo, AdditionalAgreementMapper agreementMapper) {
        this.agreementRepo = agreementRepo;
        this.agreementMapper = agreementMapper;
    }

    public AdditionalAgreement getAdditionalAgreementById(Long id) {
        return agreementRepo.findById(id)
                .orElseThrow(() -> new AdditionalAgreementNotFound("Additional agreement " + id + " not found"));
    }

    public List<AdditionalAgreement> getAllAdditionalAgreements() {
        return (List<AdditionalAgreement>) agreementRepo.findAll();
    }

    public AdditionalAgreement save(AdditionalAgreementDto dto) {
        return agreementRepo.save(agreementMapper.toAdditionalAgreement(dto));
    }
}

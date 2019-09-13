package autoservice.app.additional_agreement;

import org.springframework.stereotype.Component;

@Component
public class AdditionalAgreementMapper {
    public AdditionalAgreementDto toAdditionalAgreementDto(AdditionalAgreement additionalAgreement) {
        AdditionalAgreementDto dto = new AdditionalAgreementDto();
        dto.setCarVin(additionalAgreement.getCar().getVin());
        return dto;
    }
}

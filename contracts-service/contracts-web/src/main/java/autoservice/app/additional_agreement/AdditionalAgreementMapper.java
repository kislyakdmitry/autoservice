package autoservice.app.additional_agreement;

import autoservice.app.additional_agreement.dto.AdditionalAgreementDto;
import autoservice.app.additional_agreement.exceptions.AdditionalAgreementBadRequest;
import autoservice.app.contract.ContractRepo;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AdditionalAgreementMapper {
    private final ContractRepo contractRepo;

    public AdditionalAgreementMapper(ContractRepo contractRepo) {
        this.contractRepo = contractRepo;
    }

    public AdditionalAgreement toAdditionalAgreement(AdditionalAgreementDto dto) {

        AdditionalAgreement agreement = new AdditionalAgreement();

        if (Objects.nonNull(dto.getContractId())) {
            agreement.setContract(contractRepo.findById(dto.getContractId()).get());
        } else {
            throw new AdditionalAgreementBadRequest("contract_id is not presented");
        }

        return agreement;
    }
}

package autoservice.app.additional_agreement;

import autoservice.app.additional_agreement.dto.AdditionalAgreementDto;
import autoservice.app.additional_agreement.exceptions.AdditionalAgreementBadRequest;
import autoservice.app.contract.ContractService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AdditionalAgreementMapper {
    private ContractService contractService;

    public AdditionalAgreementMapper(ContractService contractService) {
        this.contractService = contractService;
    }

    public AdditionalAgreement toAdditionalAgreement(AdditionalAgreementDto dto) {

        AdditionalAgreement agreement = new AdditionalAgreement();

        if (Objects.nonNull(dto.getContractId())) {
            agreement.setContract(contractService.getContractById(dto.getContractId()));
        } else {
            throw new AdditionalAgreementBadRequest("contract_id is not presented");
        }

        return agreement;
    }
}

package autoservice.app.mappers;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.dto.AdditionalAgreementDto;
import autoservice.app.exceptions.AdditionalAgreementBadRequest;
import autoservice.app.services.CarsService;
import autoservice.app.services.ContractsService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AgreementMapper {

    private CarsService carsService;
    private ContractsService contractsService;

    public AgreementMapper(CarsService carsService, ContractsService contractsService) {
        this.carsService = carsService;
        this.contractsService = contractsService;
    }

    public AdditionalAgreement toAdditionalAgreement(AdditionalAgreementDto dto) {

        AdditionalAgreement agreement = new AdditionalAgreement();

        if (Objects.nonNull(dto.getCarId())) {
            agreement.setCar(carsService.getCarById(dto.getCarId()));
        } else {
            throw new AdditionalAgreementBadRequest("car_id is not presented");
        }

        if (Objects.nonNull(dto.getContractId())) {
            agreement.setContract(contractsService.getContractById(dto.getContractId()));
        } else {
            throw new AdditionalAgreementBadRequest("contract_id is not presented");
        }

        return agreement;
    }
}

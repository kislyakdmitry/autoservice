package autoservice.app.additional_agreement;

import autoservice.app.car.Car;
import autoservice.app.car.CarService;
import autoservice.app.contract.Contract;
import autoservice.app.contract.ContractRepo;
import autoservice.app.contract.exceptions.ContractNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdditionalAgreementService {

    private AdditionalAgreementRepo agreementRepo;
    private ContractRepo contractRepo;
    private CarService carService;
    private AdditionalAgreementMapper additionalAgreementMapper;

    public List<AdditionalAgreementDto> getAllAdditionalAgreements(Long id) {
        List<AdditionalAgreement> agreements = agreementRepo.findAdditionalAgreementsByContract_Id(id);
        return agreements.stream().map(additionalAgreementMapper::toAdditionalAgreementDto).collect(Collectors.toList());
    }

    public void save(String carVin, Long contractId) {
        Contract contract = contractRepo.findById(contractId).orElseThrow(() -> new ContractNotFoundException("Contract " + contractId + " not found"));
        Car car = carService.getCarByVin(carVin);
        car.setAvailable(false);
        carService.save(car);
        agreementRepo.save(AdditionalAgreement.builder().car(car).contract(contract).build());
    }
}

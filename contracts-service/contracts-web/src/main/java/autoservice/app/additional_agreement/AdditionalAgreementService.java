package autoservice.app.additional_agreement;

import autoservice.app.car.Car;
import autoservice.app.car.CarService;
import autoservice.app.contract.Contract;
import autoservice.app.contract.ContractRepo;
import autoservice.app.contract.ContractService;
import autoservice.app.contract.dto.ContractDto;
import autoservice.app.contract.exceptions.ContractNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdditionalAgreementService {

    private AdditionalAgreementRepo agreementRepo;
    private ContractRepo contractRepo;
    private CarService carService;

    public List<AdditionalAgreement> getAllAdditionalAgreements(Long id) {
        return agreementRepo.findAdditionalAgreementsByContract_Id(id);
    }

    public void save(String carVin, Long contractId) {
        Contract contract = contractRepo.findById(contractId).orElseThrow(() -> new ContractNotFoundException("Contract " + contractId + " not found"));
        Car car = carService.getCarByVin(carVin);
        agreementRepo.save(AdditionalAgreement.builder().car(car).contract(contract).build());
    }
}

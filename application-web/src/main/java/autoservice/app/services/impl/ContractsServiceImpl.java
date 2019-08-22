package autoservice.app.services.impl;

import autoservice.app.domain.Contract;
import autoservice.app.dto.ContractDto;
import autoservice.app.exceptions.ContractNotFoundException;
import autoservice.app.mappers.ContractMapper;
import autoservice.app.repositories.ContractsRepo;
import autoservice.app.services.ContractsService;
import autoservice.app.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractsServiceImpl implements ContractsService {

    private ContractsRepo contractsRepo;
    private ContractMapper contractMapper;
    private UsersService usersService;

    public Contract getContractById(Long id) {
        return contractsRepo.findById(id)
                .orElseThrow(() -> new ContractNotFoundException("Contract " + id + " not found"));
    }

    public List<Contract> getAllContracts() {
        return (List<Contract>) contractsRepo.findAll();
    }

    public Contract save(ContractDto contractDto) {
        Contract contract = contractMapper.toContract(contractDto);
        contract.setCustomer(usersService.getCurrentUser());
        return contractsRepo.save(contract);
    }
}

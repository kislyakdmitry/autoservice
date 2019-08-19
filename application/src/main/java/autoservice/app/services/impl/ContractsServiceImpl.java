package autoservice.app.services.impl;

import autoservice.app.dto.ContractDto;
import autoservice.app.exceptions.ContractNotFoundException;
import autoservice.app.mappers.ContractMapper;
import autoservice.app.services.ContractsService;
import autoservice.app.services.UsersService;
import autoservice.data.domain.Contract;
import autoservice.data.repositories.ContractsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContractsServiceImpl implements ContractsService {
    private ContractsRepo contractsRepo;
    private ContractMapper contractMapper;
    private UsersService usersService;

    public ContractsServiceImpl(ContractsRepo contractsRepo,
                                ContractMapper contractMapper,
                                UsersService usersService) {
        this.contractsRepo = contractsRepo;
        this.contractMapper = contractMapper;
        this.usersService = usersService;
    }

    public Contract getContractById(Long id) {
        return contractsRepo.findById(id)
                .orElseThrow(() -> new ContractNotFoundException("Contract " + id + " not found"));
    }

    public List<Contract> getAllContracts() {
        return contractsRepo.findAll();
    }

    public Contract save(ContractDto contractDto) {
        Contract contract = contractMapper.toContract(contractDto);
        contract.setCustomer(usersService.getCurrentUser());
        contract.setCreated(LocalDateTime.now());
        return contractsRepo.save(contract);
    }
}

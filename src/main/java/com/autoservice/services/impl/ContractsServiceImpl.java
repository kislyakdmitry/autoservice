package com.autoservice.services.impl;

import com.autoservice.domain.Contract;
import com.autoservice.dto.ContractDto;
import com.autoservice.exceptions.ContractNotFoundException;
import com.autoservice.mappers.ContractMapper;
import com.autoservice.repositories.ContractsRepo;
import com.autoservice.services.ContractsService;
import com.autoservice.services.UsersService;
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

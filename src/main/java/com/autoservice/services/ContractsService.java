package com.autoservice.services;

import com.autoservice.domain.Contract;
import com.autoservice.exceptions.ContractNotFoundException;
import com.autoservice.repositories.ContractsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractsService {
    private ContractsRepo contractsRepo;

    public ContractsService(ContractsRepo contractsRepo) {
        this.contractsRepo = contractsRepo;
    }

    public Contract getContractById(Long id) {
        return contractsRepo.findById(id)
                .orElseThrow(() -> new ContractNotFoundException("Contract " + id + " not found"));
    }

    public List<Contract> getAllContracts() {
        return contractsRepo.findAll();
    }
}

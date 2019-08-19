package com.autoservice.services;

import com.autoservice.domain.Contract;
import com.autoservice.dto.ContractDto;

import java.util.List;

public interface ContractsService {
    Contract getContractById(Long id);

    List<Contract> getAllContracts();

    Contract save(ContractDto contractDto);
}

package autoservice.app.services;

import autoservice.app.dto.ContractDto;
import autoservice.data.domain.Contract;

import java.util.List;

public interface ContractsService {
    Contract getContractById(Long id);

    List<Contract> getAllContracts();

    Contract save(ContractDto contractDto);
}

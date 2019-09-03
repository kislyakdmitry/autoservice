package autoservice.app.services;

import autoservice.app.dto.ContractDto;
import autoservice.app.domain.Contract;
import autoservice.app.dto.ContractSaveDto;

import java.util.List;

public interface ContractsService {
    Contract getContractById(Long id);

   List<ContractDto> getAllContracts();

    Contract save(ContractSaveDto contractSaveDto);
}

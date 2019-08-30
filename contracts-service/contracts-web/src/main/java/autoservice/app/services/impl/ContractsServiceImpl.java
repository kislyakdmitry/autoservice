package autoservice.app.services.impl;

import autoservice.app.domain.Contract;
import autoservice.app.domain.Employee;
import autoservice.app.dto.ContractDto;
import autoservice.app.exceptions.ContractNotFoundException;
import autoservice.app.mappers.ContractMapper;
import autoservice.app.repositories.ContractsRepo;
import autoservice.app.services.ContractsService;
import autoservice.app.services.CustomersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractsServiceImpl implements ContractsService {

    private ContractsRepo contractsRepo;
    private ContractMapper contractMapper;
    private CustomersService customersService;
    private UserDetailsServiceImpl userDetailsService;

    public ContractsServiceImpl(ContractsRepo contractsRepo, ContractMapper contractMapper, CustomersService customersService, UserDetailsServiceImpl userDetailsService) {
        this.contractsRepo = contractsRepo;
        this.contractMapper = contractMapper;
        this.customersService = customersService;
        this.userDetailsService = userDetailsService;
    }

    public Contract getContractById(Long id) {
        return contractsRepo.findById(id)
                .orElseThrow(() -> new ContractNotFoundException("Contract " + id + " not found"));
    }

    public List<ContractDto> getAllContracts() {
        Employee employee = userDetailsService.getCurrentUser();
        return employee.getContracts().stream().map(contractMapper::toContractDto).collect(Collectors.toList());
    }

    public Contract save(ContractDto contractDto) {
        Contract contract = contractMapper.toContract(contractDto);
        contract.setCustomer(customersService.getCustomerById(1L));
        return contractsRepo.save(contract);
    }
}

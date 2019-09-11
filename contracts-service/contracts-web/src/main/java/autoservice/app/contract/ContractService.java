package autoservice.app.contract;

import autoservice.app.contract.dto.ContractDto;
import autoservice.app.contract.dto.ContractSaveDto;
import autoservice.app.contract.exceptions.ContractNotFoundException;
import autoservice.app.employee.Employee;
import autoservice.app.employee.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    private ContractRepo contractsRepo;
    private ContractMapper contractMapper;
    private EmployeeService userDetailsService;

    public ContractService(ContractRepo contractsRepo, ContractMapper contractMapper, EmployeeService userDetailsService) {
        this.contractsRepo = contractsRepo;
        this.contractMapper = contractMapper;
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

    public Contract save(ContractSaveDto contractSaveDto) {
        Contract contract = contractMapper.toContract(contractSaveDto);
        System.out.println(contract);
        return contractsRepo.save(contract);
    }


}

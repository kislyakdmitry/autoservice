package autoservice.app.controllers;

import autoservice.app.domain.Contract;
import autoservice.app.dto.ContractDto;
import autoservice.app.dto.ContractSaveDto;
import autoservice.app.services.ContractsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/contracts")
public class ContractsController {
    private ContractsService contractsService;

    public ContractsController(ContractsService contractsService) {
        this.contractsService = contractsService;
    }

    @GetMapping
    public ResponseEntity<List<ContractDto>> getAllContracts() {
        return ResponseEntity.ok(contractsService.getAllContracts());
    }

    @GetMapping("/{contractId}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long contractId) {
        return ResponseEntity.ok(contractsService.getContractById(contractId));
    }

    @PostMapping
    public HttpStatus saveContract(@RequestBody ContractSaveDto contractSaveDto) {
        if (Objects.isNull(contractSaveDto)) {
            return HttpStatus.BAD_REQUEST;
        }
        Contract contract = contractsService.save(contractSaveDto);
        return HttpStatus.CREATED;
    }
}

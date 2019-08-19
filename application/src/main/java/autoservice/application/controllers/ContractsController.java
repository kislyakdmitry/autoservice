package autoservice.application.controllers;

import autoservice.application.dto.ContractDto;
import autoservice.application.services.ContractsService;
import autoservice.data.domain.Contract;
import autoservice.data.domain.Views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    @JsonView(Views.Contracts.class)
    public ResponseEntity<List<Contract>> getAllContracts() {
        return ResponseEntity.ok(contractsService.getAllContracts());
    }

    @GetMapping("/{contractId}")
    @JsonView(Views.Contracts.class)
    public ResponseEntity<Contract> getContractById(@PathVariable Long contractId) {
        return ResponseEntity.ok(contractsService.getContractById(contractId));
    }

    @PostMapping
    public ResponseEntity<Contract> saveContract(@RequestBody ContractDto contractDto) {
        if (Objects.nonNull(contractDto)) {
            Contract contract = contractsService.save(contractDto);
            return ResponseEntity.created(URI.create("contracts/" + contract.getId())).build();
        }
        return ResponseEntity.badRequest().build();
    }
}

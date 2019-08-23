package autoservice.app.controllers;

import autoservice.app.dto.ContractDto;
import autoservice.app.services.ContractsService;
import autoservice.app.domain.Contract;
import autoservice.app.domain.views.Views;
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
        if (Objects.isNull(contractDto)) {
            return ResponseEntity.badRequest().build();
        }
        Contract contract = contractsService.save(contractDto);
        return ResponseEntity.created(URI.create("contracts/" + contract.getId())).build();

    }
}

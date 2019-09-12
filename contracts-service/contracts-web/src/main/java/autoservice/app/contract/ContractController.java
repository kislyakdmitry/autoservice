package autoservice.app.contract;

import autoservice.app.contract.dto.ContractDto;
import autoservice.app.contract.dto.ContractSaveDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/contracts")
public class ContractController {
    private ContractService contractsService;

    public ContractController(ContractService contractsService) {
        this.contractsService = contractsService;
    }

    @GetMapping
    public ResponseEntity<List<ContractDto>> getAllContracts() {
        return ResponseEntity.ok(contractsService.getAllContracts());
    }

    @GetMapping("/{contractId}")
    public ResponseEntity<ContractDto> getContractById(@PathVariable Long contractId) {
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

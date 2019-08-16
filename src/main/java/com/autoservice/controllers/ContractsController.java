package com.autoservice.controllers;

import com.autoservice.domain.Contract;
import com.autoservice.domain.Views.Views;
import com.autoservice.services.ContractsService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Contract> getContractById(@PathVariable Long contractId) {
        return ResponseEntity.ok(contractsService.getContractById(contractId));
    }
}

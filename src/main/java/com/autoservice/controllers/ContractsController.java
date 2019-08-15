package com.autoservice.controllers;

import com.autoservice.domain.Contract;
import com.autoservice.services.ContractsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/contracts")
public class ContractsController {
    private ContractsService contractsService;

    public ContractsController(ContractsService contractsService) {
        this.contractsService = contractsService;
    }

    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts() {
        return ResponseEntity.ok(contractsService.getAllContracts());
    }

    @GetMapping("/{contractId}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long contractId) {
        return ResponseEntity.ok(contractsService.getContractById(contractId));
    }
}

package com.autoservice.exceptions;

public class ContractNotFoundException extends RuntimeException {
    public ContractNotFoundException() {
    }

    public ContractNotFoundException(String message) {
        super(message);
    }
}

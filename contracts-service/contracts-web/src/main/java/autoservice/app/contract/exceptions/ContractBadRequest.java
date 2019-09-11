package autoservice.app.contract.exceptions;

public class ContractBadRequest extends RuntimeException {
    public ContractBadRequest() {
        super();
    }

    public ContractBadRequest(String message) {
        super(message);
    }
}

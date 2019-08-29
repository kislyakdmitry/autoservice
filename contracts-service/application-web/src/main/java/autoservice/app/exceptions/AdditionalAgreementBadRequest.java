package autoservice.app.exceptions;

public class AdditionalAgreementBadRequest extends RuntimeException {
    public AdditionalAgreementBadRequest() {
        super();
    }

    public AdditionalAgreementBadRequest(String message) {
        super(message);
    }
}

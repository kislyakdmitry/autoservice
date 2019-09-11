package autoservice.app.additional_agreement.exceptions;

public class AdditionalAgreementBadRequest extends RuntimeException {
    public AdditionalAgreementBadRequest() {
        super();
    }

    public AdditionalAgreementBadRequest(String message) {
        super(message);
    }
}

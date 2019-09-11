package autoservice.app.additional_agreement;

import autoservice.app.additional_agreement.dto.AdditionalAgreementDto;
import autoservice.app.contract.Contract;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/agreements")
public class AdditionalAgreementsController {
    private AdditionalAgreementService agreementService;

    public AdditionalAgreementsController(AdditionalAgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @GetMapping
    public ResponseEntity<List<AdditionalAgreement>> getAllAdditionalAgreements() {
        return ResponseEntity.ok(agreementService.getAllAdditionalAgreements());
    }

    @GetMapping("/{agreementId}")
    public ResponseEntity<AdditionalAgreement> getAdditionalAgreementById(@PathVariable Long agreementId) {
        return ResponseEntity.ok(agreementService.getAdditionalAgreementById(agreementId));
    }

    @PostMapping
    public ResponseEntity<Contract> saveContract(@RequestBody AdditionalAgreementDto dto) {
        if (Objects.isNull(dto)) {
            return ResponseEntity.badRequest().build();
        }
        AdditionalAgreement agreement = agreementService.save(dto);
        return ResponseEntity.created(URI.create("agreements/" + agreement.getId())).build();

    }
}

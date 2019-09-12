package autoservice.app.additional_agreement;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/contracts/{contractId}/agreements")
@AllArgsConstructor
public class AdditionalAgreementsController {

    private final AdditionalAgreementService agreementService;

    @GetMapping
    public ResponseEntity<List<AdditionalAgreement>> getAllAdditionalAgreements(@PathVariable Long contractId) {
        return ResponseEntity.ok(agreementService.getAllAdditionalAgreements(contractId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveAgreement(@RequestBody AdditionalAgreementDto dto, @PathVariable Long contractId) {
        if (Objects.isNull(dto.getCarVin())) {
            return ResponseEntity.badRequest().build();
        }
        agreementService.save(dto.getCarVin(), contractId);
        return ResponseEntity.created(URI.create("/contracts/" + contractId + "/agreements")).build();
    }
}

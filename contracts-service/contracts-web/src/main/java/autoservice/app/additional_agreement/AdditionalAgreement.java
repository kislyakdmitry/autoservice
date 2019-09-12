package autoservice.app.additional_agreement;

import autoservice.app.car.Car;
import autoservice.app.common.GenericEntity;
import autoservice.app.contract.Contract;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "additional_agreements")
@Data
@EqualsAndHashCode(callSuper = true)
public class AdditionalAgreement extends GenericEntity<Long> {
    @Id
    @SequenceGenerator(
            name = "additional_agreements_id_seq",
            sequenceName = "additional_agreements_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "additional_agreements_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;
}

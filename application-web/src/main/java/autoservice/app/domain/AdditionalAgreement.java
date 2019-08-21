package autoservice.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "additional_agreements")
@Data
@EqualsAndHashCode(callSuper = true)
public class AdditionalAgreement extends GenericEntity {
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

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
}

package autoservice.app.domain;

import autoservice.app.domain.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "contracts")
@Data
@EqualsAndHashCode(callSuper = true)
public class Contract extends GenericEntity<Long> {
    @Id
    @SequenceGenerator(name = "contracts_id_seq", sequenceName = "contracts_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contracts_id_seq")
    private Long id;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "end_time")
    private LocalDate endTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ElementCollection
    @CollectionTable(name="contracts_cars", joinColumns=@JoinColumn(name="contract_id"))
    @Column(name="car_vin")
    private List<String> cars;
}

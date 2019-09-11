package autoservice.app.contract;

import autoservice.app.car.Car;
import autoservice.app.common.GenericEntity;
import autoservice.app.customer.Customer;
import autoservice.app.employee.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contracts_cars",
            joinColumns = {@JoinColumn(name = "contract_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private List<Car> cars;
}

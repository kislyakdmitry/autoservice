package autoservice.app.employee;

import autoservice.app.common.GenericEntity;
import autoservice.app.contract.Contract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends GenericEntity<Long> {
    @Id
    @SequenceGenerator(name = "employees_id_seq", sequenceName = "employees_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_id_seq")
    private Long id;

    private String username;
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Contract> contracts;
}

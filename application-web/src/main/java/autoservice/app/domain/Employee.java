package autoservice.app.domain;

import autoservice.app.domain.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends GenericEntity {
    @Id
    @SequenceGenerator(name = "employees_id_seq", sequenceName = "employees_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_id_seq")
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "first_name")
    @JsonView(Views.Contracts.class)
    private String firstName;

    @Column(name = "last_name")
    @JsonView(Views.Contracts.class)
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Contract> contracts;
}

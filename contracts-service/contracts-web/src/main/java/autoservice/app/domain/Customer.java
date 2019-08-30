package autoservice.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends GenericEntity<Long> {
    @Id
    @SequenceGenerator(name = "customers_id_seq", sequenceName = "customers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    private Long id;

    @Column(name = "first_name")
    @JsonView(autoservice.app.domain.views.Views.Contracts.class)
    private String firstName;

    @Column(name = "last_name")
    @JsonView(autoservice.app.domain.views.Views.Contracts.class)
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonIgnore
    private List<Contract> contracts;
}

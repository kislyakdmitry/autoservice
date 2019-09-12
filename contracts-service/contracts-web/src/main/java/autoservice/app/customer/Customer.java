package autoservice.app.customer;

import autoservice.app.common.GenericEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends GenericEntity<Long> {
    @Id
    @SequenceGenerator(name = "customers_id_seq", sequenceName = "customers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}

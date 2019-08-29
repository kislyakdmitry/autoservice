package autoservice.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "cars")
@Data
@EqualsAndHashCode(callSuper = true)
public class Car extends GenericEntity<Long> {
    @Id
    @SequenceGenerator(name = "cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_id_seq")
    private Long id;

    private String name;
    private BigDecimal price;
}
